package com.nttdata.stepsdefinitions;

import com.nttdata.steps.LoginValidacionMyStoreStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;

public class LoginValidacionMyStoreStepdefs {

    private LoginValidacionMyStoreStep loginValidacionMyStoreStep;

    public LoginValidacionMyStoreStepdefs() {
        loginValidacionMyStoreStep = new LoginValidacionMyStoreStep(getDriver());
    }

    @Given("estoy en la página de la tienda")
    public void estoyEnLaPaginaDeLaTienda() {
        loginValidacionMyStoreStep.navegarALaPaginaDeTienda();
    }


    @And("me logueo con mi usuario {string} y clave {string}")
    public void meLogueoConMiUsuarioYClave(String userName, String userPassword) {
        loginValidacionMyStoreStep.LogueoConUsuarioYClave(userName, userPassword);
    }

    @When("navego a la categoria {string} y subcategoria {string}")
    public void navegoALaCategoriaYSubcategoria(String category, String subcategory) {
        loginValidacionMyStoreStep.NavegoALaCategoriaYSubcateogira(category, subcategory);
    }

    @And("agrego {} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int unidades) {
        loginValidacionMyStoreStep.AgregoUnidadesDelPrimerProducto(unidades);
    }

    @Then("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmacionDelProductoAgregado() {
        loginValidacionMyStoreStep.validoElPopupDeConfirmacionDelProductoAgregado();
    }

    @And("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {
        loginValidacionMyStoreStep.validoElMontoTotal();
    }

    @When("finalizo la compra")
    public void finalizoLaCompra() {
        loginValidacionMyStoreStep.finalizoLaCompra();
    }

    @Then("valido el titulo de la pagina del carrito")
    public void validoElTituloDeLaPaginaDelCarrito() {
        loginValidacionMyStoreStep.validoElTituloDelCarrito();
    }

    @And("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() {
        loginValidacionMyStoreStep.validoNuevamenteLosPrecios();
    }
}
