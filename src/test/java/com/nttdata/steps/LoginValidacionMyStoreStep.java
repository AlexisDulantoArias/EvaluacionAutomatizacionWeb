package com.nttdata.steps;

import com.nttdata.page.MyStorePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

import static com.nttdata.core.DriverManager.screenShot;

public class LoginValidacionMyStoreStep {
    private WebDriver driver;

    public LoginValidacionMyStoreStep(WebDriver driver) {
        this.driver = driver;
    }

    public void navegarALaPaginaDeTienda() {
        driver.get("https://qalab.bensg.com/store/pe/");
        screenShot();
    }

    public void LogueoConUsuarioYClave(String userName, String userPassword) {
        iniciarSesion();
        typeUser(userName);
        typePassword(userPassword);
        login();
        loginExitoso();
        screenShot();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    public void iniciarSesion() {
        driver.findElement(MyStorePage.IniciarSesion).click();
    }

    public void typeUser(String userName) {
        WebElement userInputElement = driver.findElement(MyStorePage.Usuario);
        userInputElement.sendKeys(userName);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(MyStorePage.InicioSesionBtn));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    public void typePassword(String userPassword) {
        WebElement passInputElement = driver.findElement(MyStorePage.Pass);
        passInputElement.sendKeys(userPassword);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    public void login() {
        driver.findElement(MyStorePage.InicioSesionBtn).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    public void loginExitoso() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            WebElement errorMensaje = wait.until(ExpectedConditions.visibilityOfElementLocated(MyStorePage.ErrorLogin));
            System.out.println("Login fallido: Credenciales incorrectas.");
            Assertions.fail("El login falló debido a credenciales incorrectas.");
        } catch (TimeoutException e) {
            System.out.println("Login exitoso.");
        }
    }

    public void NavegoALaCategoriaYSubcateogira(String category, String subcategory) {
        if (Objects.equals(category, "clothes")) {
            driver.findElement(MyStorePage.CategoriaClothes).click();
            if (Objects.equals(subcategory, "men")){
                driver.findElement(MyStorePage.SubCategoriaMen).click();
            } else if (Objects.equals(subcategory, "women")){
                driver.findElement(MyStorePage.SubCategoriaWomen).click();
            } else {
                System.out.println("La subcategoria no existe");
            }
        } else if (Objects.equals(category, "accesorios")) {
            driver.findElement(MyStorePage.CategoriaAccesorios).click();
        } else if (Objects.equals(category, "art")) {
            driver.findElement(MyStorePage.CategoriaArt).click();
        } else {
            System.out.println("La categoria no existe");
            throw new IllegalArgumentException("La categoría proporcionada no es válida: " + category);
        }
    }

    public void AgregoUnidadesDelPrimerProducto(int unidades) {
        driver.findElement(MyStorePage.UnidadesDePedido).click();
        WebElement passInputElement = driver.findElement(MyStorePage.SubirCantidadDePedido);
        int clicsNecesarios = unidades - 1;
        for (int i = 0; i < clicsNecesarios; i++) {
            passInputElement.click();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    public void validoElPopupDeConfirmacionDelProductoAgregado() {
        driver.findElement(MyStorePage.AnadirAlCarritoBtn).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(MyStorePage.Modal));
    }


    public void validoElMontoTotal() {
        WebElement precio = driver.findElement(MyStorePage.PrecioUnitario);
        WebElement total = driver.findElement(MyStorePage.NumeroDeObjetos);
        WebElement precioFinal = driver.findElement(MyStorePage.PrecioTotal);

        String precioTexto = precio.getText();
        String totalTexto = total.getText();
        String precioFinalTexto = precioFinal.getText();

        precioTexto = precioTexto.replaceAll("[^0-9]", "");
        totalTexto = totalTexto.replaceAll("[^0-9]", "");
        precioFinalTexto = precioFinalTexto.replaceAll("[^0-9]", "");

        double precioInt = Double.parseDouble(precioTexto);
        int totalInt = Integer.parseInt(totalTexto);
        double precioTotalInt = Double.parseDouble(precioFinalTexto);

        if (precioInt * totalInt == precioTotalInt) {
            System.out.println("El precio total está bien calculado");
        } else {
            System.out.println("El precio total no está bien calculado");
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    public void finalizoLaCompra() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(MyStorePage.FinalizarCompraModalBtn));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(MyStorePage.FinalizarCompraModalBtn).click();
    }

    public void validoElTituloDelCarrito() {
        String actualTitle = driver.findElement(MyStorePage.TituloCarrito).getText();
        Assertions.assertEquals("CARRITO", actualTitle, "El título no coincide con el esperado.");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(MyStorePage.FinalizarCompraBtn));
    }

    public void validoNuevamenteLosPrecios() {
        WebElement precioCarrito = driver.findElement(MyStorePage.PrecioUnitarioCarrito);
        WebElement inputCarrito = driver.findElement(MyStorePage.NumeroDeObjetosCarrito);
        WebElement precioFinalCarrito = driver.findElement(MyStorePage.PrecioTotalCarrito);
        String totalCarrito = inputCarrito.getAttribute("value");

        String precioTextoCarrito = precioCarrito.getText();
        String totalTextoCarrito = totalCarrito;
        String precioFinalCarritoTexto = precioFinalCarrito.getText();

        precioTextoCarrito = precioTextoCarrito.replaceAll("[^0-9.]", ""); // Incluye punto para decimales
        totalTextoCarrito = totalTextoCarrito.replaceAll("[^0-9]", "");    // No se esperan decimales aquí
        precioFinalCarritoTexto = precioFinalCarritoTexto.replaceAll("[^0-9.]", "");

        double precioCarritoDouble = Double.parseDouble(precioTextoCarrito);
        int totalCarritoInt = Integer.parseInt(totalTextoCarrito);
        double precioTotalCarritoDouble = Double.parseDouble(precioFinalCarritoTexto);

        if (precioCarritoDouble * totalCarritoInt == precioTotalCarritoDouble) {
            System.out.println("El precio total en el carrito está bien calculado");
        } else {
            System.out.println("El precio total en el carrito no está bien calculado");
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
