package geo.geopoints.gRpc;

import geo.geopoints.models.Ggs;
import geo.geopoints.models.Gns;
import geo.geopoints.services.GgsService;
import geo.geopoints.services.GnsService;
import geopoints.Geopoints;
import geopoints.GeopointsServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@GrpcService
public class GeopointsServiceImpl extends GeopointsServiceGrpc.GeopointsServiceImplBase {
    @Autowired
    private GgsService ggsService;
    @Autowired
    private GnsService gnsService;

    @Override
    public void ggs(Geopoints.GgsRequest request,
                    StreamObserver<Geopoints.GgsResponse> responseStreamObserver) {
        List<Ggs> ggsList = ggsService.findByCoordinates(request.getLatitude(), request.getLongitude(),
                request.getRadius());
        for (Ggs ggs : ggsList) {
            Geopoints.GgsResponse response = Geopoints.GgsResponse.newBuilder()
                    .setName(ggs.getName())
                    .setIndex(ggs.getIndex())
                    .setMark(ggs.getMark())
                    .setCenterType(ggs.getCenterType())
                    .setMsk(ggs.getMsk())
                    .setLatitude(ggs.getLatitude())
                    .setLongitude(ggs.getLongitude())
                    .build();
            responseStreamObserver.onNext(response);
        }
        responseStreamObserver.onCompleted();
    }

    @Override
    public void gns(Geopoints.GnsRequest request,
                    StreamObserver<Geopoints.GnsResponse> responseStreamObserver) {
        List<Gns> gnsList = gnsService.findByCoordinates(request.getLatitude(), request.getLongitude(),
                request.getRadius());
        for (Gns gns : gnsList) {
            Geopoints.GnsResponse response = Geopoints.GnsResponse.newBuilder()
                    .setName(gns.getName())
                    .setIndex(gns.getIndex())
                    .setMark(gns.getMark())
                    .setCenterType(gns.getCenterType())
                    .setLatitude(gns.getLatitude())
                    .setLongitude(gns.getLongitude())
                    .setMainGeographyFeature(gns.getMainGeographyFeature())
                    .setMsk(gns.getMsk())
                    .build();
            responseStreamObserver.onNext(response);
        }
        responseStreamObserver.onCompleted();
    }
}
