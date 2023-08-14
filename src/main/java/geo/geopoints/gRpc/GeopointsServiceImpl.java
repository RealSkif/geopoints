package geo.geopoints.gRpc;

import geo.geopoints.models.Ggs;
import geo.geopoints.services.GgsService;
import geopoints.Geopoints;
import geopoints.GeopointsServiceGrpc;
import io.grpc.stub.StreamObserver;
import io.grpc.stub.annotations.GrpcGenerated;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@GrpcService
public class GeopointsServiceImpl extends GeopointsServiceGrpc.GeopointsServiceImplBase {
    @Autowired
    private GgsService ggsService;


    @Override
    public void ggs(Geopoints.GgsRequest request,
                    StreamObserver<Geopoints.GgsResponse> responseStreamObserver) {
//        request.getLongitude()
        List<Ggs> ggsList = ggsService.findByCoordinates(request.getLongitude(), request.getLongitude(),
                request.getRadius());
        ggsList.forEach(x -> System.out.println(x.getName()));
//        System.out.println(request);
        Geopoints.GgsResponse response = Geopoints.GgsResponse.newBuilder()
                .setName("111")
                .build();
        responseStreamObserver.onNext(response);
        responseStreamObserver.onCompleted();
    }
}
