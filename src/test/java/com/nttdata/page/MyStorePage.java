package com.nttdata.page;

import org.openqa.selenium.By;

public class MyStorePage {
    public static By IniciarSesion = By.xpath("//*[@id=\"_desktop_user_info\"]/div/a/span");
    public static By Usuario = By.xpath("//*[@id=\"field-email\"]");
    public static By Pass = By.xpath("//*[@id=\"field-password\"]");
    public static By InicioSesionBtn = By.xpath("//*[@id=\"submit-login\"]");
    public static By ErrorLogin = By.xpath("//*[@id=\"content\"]/section/div/ul/li");
    public static By CategoriaClothes = By.xpath("//*[@id=\"category-3\"]/a");
    public static By CategoriaAccesorios = By.xpath("//*[@id=\"category-6\"]/a");
    public static By CategoriaArt = By.xpath("//*[@id=\"category-9\"]/a");
    public static By SubCategoriaMen = By.xpath("//*[@id=\"subcategories\"]/ul/li[1]");
    public static By SubCategoriaWomen = By.xpath("//*[@id=\"subcategories\"]/ul/li[2]/div[1]/a");
    public static By UnidadesDePedido = By.xpath("//*[@id=\"js-product-list\"]/div[1]/div/article");
    public static By SubirCantidadDePedido = By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[1]/div/span[3]/button[1]");
    public static By AnadirAlCarritoBtn = By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button");
    public static By Modal = By.xpath("//*[@id=\"blockcart-modal\"]");
    public static By FinalizarCompraModalBtn = By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a");
    public static By PrecioUnitario = By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[1]/div/div[2]/p");
    public static By NumeroDeObjetos = By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[1]/div/div[2]/span[3]/strong");
    public static By PrecioTotal = By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/p[4]/span[2]");
    public static By TituloCarrito = By.xpath("//*[@id=\"main\"]/div/div[1]/div/div[1]/h1");
    public static By PrecioUnitarioCarrito = By.xpath("//*[@id=\"main\"]/div/div[1]/div/div[2]/ul/li/div/div[2]/div[2]/div[2]/span");
    public static By NumeroDeObjetosCarrito = By.xpath("//*[@id=\"main\"]/div/div[1]/div/div[2]/ul/li/div/div[3]/div/div[2]/div/div[1]/div/input");
    public static By PrecioTotalCarrito = By.xpath("//*[@id=\"main\"]/div/div[1]/div/div[2]/ul/li/div/div[3]/div/div[2]/div/div[2]/span/strong");
    public static By FinalizarCompraBtn = By.xpath("//*[@id=\"main\"]/div/div[2]/div[1]/div[2]/div/a");
}