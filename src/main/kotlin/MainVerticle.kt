import io.vertx.core.AbstractVerticle
import io.vertx.core.Promise
import io.vertx.ext.web.Router

class MainVerticle : AbstractVerticle() {
    override fun start(startPromise: Promise<Void>) {
        val router = Router.router(vertx)

        router.get("/hello").handler { ctx ->
            ctx.response()
                .putHeader("Content-Type", "text/plain")
                .end("Hello, Vert.x!")
        }

        vertx.createHttpServer()
            .requestHandler(router)
            .listen(8888) { res ->
                if (res.succeeded()) {
                    startPromise.complete()
                    println("Server started on port 8888")
                } else {
                    startPromise.fail(res.cause())
                }
            }
    }
}

