<!DOCTYPE html>
<html lang="en">

<head>
<jsp:include page="/partes/headAdmin.jsp"></jsp:include>
</head>

<body>
	<jsp:include page="/partes/navAdmin.jsp"></jsp:include>
<!-- TITULOS-H1H2 -->


<!-- CARROUSEL -->

<div class="carousel mt-2">
    <div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">
        <div class="carousel-indicators">
            <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active"
                aria-current="true" aria-label="Slide 1"></button>
            <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1"
                aria-label="Slide 2"></button>
            <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2"
                aria-label="Slide 3"></button>
            <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="3"
                aria-label="Slide 4"></button>
            <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="4"
                aria-label="Slide 5"></button>
            <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="5"
                aria-label="Slide 6"></button>
            <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="6"
                aria-label="Slide 7"></button>
            <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="7"
                aria-label="Slide 8"></button>
        </div>

        <!-- IMAGEN DE MORDOR -->

        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="https://cdn.vox-cdn.com/thumbor/kxHLpEW6ltPiHqi8y4wtHLUBF9Y=/0x0:3150x1575/fit-in/1200x600/cdn.vox-cdn.com/uploads/chorus_asset/file/22280932/ROTK_eye_of_sauron.jpg"
                    class="d-block w-100" alt="">
                <div class="carousel-caption d-none d-md-block">
                    <h5>INFORMACION DE MORDOR</h5>
                    <p>MORDOR</p>
                </div>
            </div>

            <!-- IMAGEN DE MINAS TIRITH -->

            <div class="carousel-item">
                <img src="https://i.insider.com/53299296eab8ea8d73be296b?width=1200&format=jpeg" class="d-block w-100"
                    alt="...">
                <div class="carousel-caption d-none d-md-block">
                    <h5>INFORMACION DE MINAS TIRITH</h5>
                    <p>Minas Tirith</p>
                </div>
            </div>

            <!-- IMAGEN DE LA COMARCA -->

            <div class="carousel-item">
                <img src="img/LaComarca.jpeg" class="d-block w-100" alt="...">
                <div class="carousel-caption d-none d-md-block">
                    <h5>INFORMACION DE LA COMARCA</h5>
                    <p>LA COMARCA</p>
                </div>
            </div>

            <!-- IMAGEN DE MINAS DE MORIA -->

            <div class="carousel-item">
                <img src="img/MinasDeMoria.jpg" class="d-block w-100" alt="...">
                <div class="carousel-caption d-none d-md-block">
                    <h5>INFORMACION DE MORIA</h5>
                    <p>MORIA</p>
                </div>
            </div>

            <!-- IMAGEN DEL ABISMO DE HELM -->

            <div class="carousel-item">
                <img src="img/AbismoDeHelm.jpg" class="d-block w-100" alt="...">
                <div class="carousel-caption d-none d-md-block">
                    <h5>INFORMACION DEL ABISMO DE HELM</h5>
                    <p>ABISMO DE HELM</p>
                </div>
            </div>

            <!-- IMAGEN DE LOTHLORIEN -->

            <div class="carousel-item">
                <img src="img/Lothlorien.jpg" class="d-block w-100" alt="...">
                <div class="carousel-caption d-none d-md-block">
                    <h5>INFORMACION DE LOTHLORIEN</h5>
                    <p>LOTHLORIEN</p>
                </div>
            </div>

            <!-- IMAGEN DE EREBOR -->

            <div class="carousel-item">
                <img src="img/Erebor.jpg" class="d-block w-100" alt="...">
                <div class="carousel-caption d-none d-md-block">
                    <h5>INFORMACION DE EREBOR</h5>
                    <p>EREBOR</p>
                </div>
            </div>

            <!-- IMAGEN DEL BOSQUE NEGRO -->

            <div class="carousel-item">
                <img src="img/BosqueNegro.jpg" class="d-block w-100" alt="...">
                <div class="carousel-caption d-none d-md-block">
                    <h5>INFORMACION DEl BOSQUE NEGRO</h5>
                    <p>BOSQUE NEGRO</p>
                </div>
            </div>
        </div>



        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions"
            data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Anterior</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions"
            data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Siguiente</span>
        </button>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
    crossorigin="anonymous"></script>
</body>

</html>