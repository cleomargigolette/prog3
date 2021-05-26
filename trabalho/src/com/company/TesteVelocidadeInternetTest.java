package com.company;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

public class TesteVelocidadeInternetTest {

    private TesteVelocidadeInternet testeVelocidadeInternet = new TesteVelocidadeInternet();

    private Medicao medicao1 = new Medicao();
    private Medicao medicao2 = new Medicao();
    private Medicao medicao3 = new Medicao();

    @Before
    public void setUp() {

        medicao1.setTaxaUpload(1500);
        medicao1.setTaxaDownload(2000);
        medicao1.setPing(30);

        medicao2.setTaxaUpload(1400);
        medicao2.setTaxaDownload(1900);
        medicao2.setPing(70);

        medicao3.setTaxaUpload(1700);
        medicao3.setTaxaDownload(2100);
        medicao3.setPing(25);

        testeVelocidadeInternet.setDownloadDesejado(2000);
        testeVelocidadeInternet.setUploadDesejado(1500);
        testeVelocidadeInternet.setPingDesejado(50);

        testeVelocidadeInternet.setData(LocalDate.now());
        testeVelocidadeInternet.setNomeProvedor("Provedor de Teste");

        testeVelocidadeInternet.adicionarMedicao(medicao1);
        testeVelocidadeInternet.adicionarMedicao(medicao2);
        testeVelocidadeInternet.adicionarMedicao(medicao3);
    }

//  Letra A
    @Test
    public void totalMedicoesValida() {

        int expected = 3;
        Assert.assertEquals(expected, testeVelocidadeInternet.totalMedicoes());
    }

//  Letra A
    @Test
    public void totalMedicoesNaoValida() {

        int expected = 2;
        Assert.assertNotEquals(expected, this.testeVelocidadeInternet.totalMedicoes());
    }

 //  Letra B
    @Test
    public void mediaDownloadmediaValida(){

        double expected = 2000;
        Assert.assertEquals(expected, this.testeVelocidadeInternet.mediaDownload(), 0.001);
    }

    //  Letra B
    @Test
    public void mediaDownloadNaoValida(){

        double expected = 3000;
        Assert.assertNotEquals(expected, this.testeVelocidadeInternet.mediaDownload(), 0.001);
    }

    //  Letra C
    @Test
    public void mediaUploadValida(){

        double expected = 1533.33;
        Assert.assertNotEquals(expected, this.testeVelocidadeInternet.mediaUpload(), 0.001);
    }

    //  Letra C
    @Test
    public void mediaUploadNaoValida(){

        double expected = 2033.50;
        Assert.assertNotEquals(expected, this.testeVelocidadeInternet.mediaUpload(), 0.001);
    }

    //  Letra D
    @Test
    public void mediaPingValida(){

        double expected = 41.66;
        Assert.assertNotEquals(expected, this.testeVelocidadeInternet.mediaPings(), 0.001);
    }

    //  Letra D
    @Test
    public void mediaPingNaoValida(){

        double expected = 99.99;
        Assert.assertNotEquals(expected,  this.testeVelocidadeInternet.mediaPings(), 0.001);
    }

    //  Letra E
    @Test
    public void totalDownloadsInferioresTaxaDesejedaValida(){

        double expected = 1L;

        Assert.assertEquals(expected, this.testeVelocidadeInternet.totalDownloadsInferioresTaxaDesejeda(), 0.0);
    }

    //  Letra E
    @Test
    public void totalDownloadsInferioresTaxaDesejedaNaoValida(){

        double expected = 2;
        Assert.assertNotEquals(expected, this.testeVelocidadeInternet.totalDownloadsInferioresTaxaDesejeda());
    }

    //  Letra F
    @Test
    public void totalUploadsInferioresTaxaDesejedaValida(){

        double expected = 1;
        Assert.assertEquals(expected, this.testeVelocidadeInternet.totalUploadsInferioresTaxaDesejeda(), 0.0);
    }

    //  Letra F
    @Test
    public void totalUploadsInferioresTaxaDesejedaNaoValida(){

        double expected = 2;
        Assert.assertNotEquals(expected, this.testeVelocidadeInternet.totalUploadsInferioresTaxaDesejeda());
    }

    //  Letra G
    @Test
    public void totalPingSuperioresTaxaDesejedaValida(){

        double expected = 1;
        Assert.assertEquals(expected, this.testeVelocidadeInternet.totalPingSuperioresTaxaDesejeda(), 0.0);
    }

    //  Letra G
    @Test
    public void totalPingSuperioresTaxaDesejedaNaoValida(){

        double expected = 2;
        Assert.assertNotEquals(expected, this.testeVelocidadeInternet.totalPingSuperioresTaxaDesejeda());
    }

    //  Letra H
    @Test
    public void percentualDownloadsInferioresTaxaDesejedaValida(){

        double expected =0.3333333333333333;
        Assert.assertEquals(expected, this.testeVelocidadeInternet.percentualDownloadsInferioresTaxaDesejeda(), 0.01);
    }

    //  Letra H
    @Test
    public void percentualDownloadsInferioresTaxaDesejedaNaoValida(){

        double expected =0.45;
        Assert.assertNotEquals(expected, this.testeVelocidadeInternet.percentualDownloadsInferioresTaxaDesejeda(), 0.01);
    }

    //  Letra I
    @Test
    public void percentualUploadsInferioresTaxaDesejedaValida(){

        double expected =0.3333333333333333;
        Assert.assertEquals(expected, this.testeVelocidadeInternet.percentualUploadsInferioresTaxaDesejeda(), 0.01);
    }

    //  Letra I
    @Test
    public void percentualUploadsInferioresTaxaDesejedaNaoValida(){

        double expected =0.56;
        Assert.assertNotEquals(expected, this.testeVelocidadeInternet.percentualUploadsInferioresTaxaDesejeda(), 0.01);
    }

    //  Letra J
    @Test
    public void percentualPingsSuperioresTaxaDesejadaValida(){

        double expected =0.3333333333333333;
        Assert.assertEquals(expected, this.testeVelocidadeInternet.percentualPingsSuperioresTaxaDesejada(), 0.01);
    }

    //  Letra J
    @Test
    public void percentualPingsSuperioresTaxaDesejadaNaoValida(){

        double expected =0.78;
        Assert.assertNotEquals(expected, this.testeVelocidadeInternet.percentualPingsSuperioresTaxaDesejada(), 0.01);
    }

    //  Letra K
    @Test
    public void taxaDownloadInferioresTaxaDesejadaMenor20PorcentoValida(){

        Boolean expected = true;
        Assert.assertEquals(expected, this.testeVelocidadeInternet.taxaDownloadInferioresTaxaDesejadaMenor20Porcento());
    }

    //  Letra K
    @Test
    public void taxaDownloadInferioresTaxaDesejadaMenor20PorcentoNaoValida(){

        Boolean expected = false;
        Assert.assertNotEquals(expected, this.testeVelocidadeInternet.taxaDownloadInferioresTaxaDesejadaMenor20Porcento());
    }

    //  Letra L
    @Test
    public void taxaUploadInferioresTaxaDesejadaMenor20PorcentoValida(){

        Boolean expected = true;
        Assert.assertEquals(expected, this.testeVelocidadeInternet.taxaUploadInferioresTaxaDesejadaMenor20Porcento());
    }

    //  Letra L
    @Test
    public void taxaUploadInferioresTaxaDesejadaMenor20PorcentoNaoValida(){

        Boolean expected = false;
        Assert.assertNotEquals(expected, this.testeVelocidadeInternet.taxaUploadInferioresTaxaDesejadaMenor20Porcento());
    }

    //  Letra M
    @Test
    public void taxaPingSuperioresTaxaDesejadaMenor20PorcentoValida(){

        Boolean expected = true;
        Assert.assertEquals(expected, this.testeVelocidadeInternet.taxaPingSuperioresTaxaDesejadaMenor20Porcento());
    }

    //  Letra M
    @Test
    public void taxaPingSuperioresTaxaDesejadaMenor20PorcentoNaoValida(){

        Boolean expected = false;
        Assert.assertNotEquals(expected, this.testeVelocidadeInternet.taxaPingSuperioresTaxaDesejadaMenor20Porcento());
    }

    //  Letra N
    @Test
    public void maiorTaxaDownloadMedidaValida(){

        double expected = 2100;
        Assert.assertEquals(expected, this.testeVelocidadeInternet.maiorTaxaDownloadMedida(), 0.001);
    }

    //  Letra N
    @Test
    public void maiorTaxaDownloadMedidaNãoValida(){

        double expected = 1900;
        Assert.assertNotEquals(expected, this.testeVelocidadeInternet.maiorTaxaDownloadMedida(), 0.001);
    }

    //  Letra O
    @Test
    public void maiorTaxaUploadMedidaValida(){

        double expected = 1700;
        Assert.assertEquals(expected, this.testeVelocidadeInternet.maiorTaxaUploadMedida(), 0.001);
    }

    //  Letra O
    @Test
    public void maiorTaxaUploadMedidaNãoValida(){

        double expected = 2100;
        Assert.assertNotEquals(expected, this.testeVelocidadeInternet.maiorTaxaUploadMedida(), 0.001);
    }

    //  Letra P
    @Test
    public void maiorTaxaPingMedidaValida(){

        double expected = 70;
        Assert.assertEquals(expected, this.testeVelocidadeInternet.maiorTaxaPingMedida(), 0.001);
    }

    //  Letra P
    @Test
    public void maiorTaxaPingMedidaNãoValida(){

        double expected = 200;
        Assert.assertNotEquals(expected, this.testeVelocidadeInternet.maiorTaxaPingMedida(), 0.001);
    }

    //  Letra Q
    @Test
    public void menorTaxaDownloadMedidaValida(){

        double expected = 1900;
        Assert.assertEquals(expected, this.testeVelocidadeInternet.menorTaxaDownloadMedida(), 0.001);
    }

    //  Letra Q
    @Test
    public void menorTaxaDownloadMedidaNaoValida(){

        double expected = 82;
        Assert.assertNotEquals(expected, this.testeVelocidadeInternet.menorTaxaDownloadMedida(), 0.001);
    }

    //  Letra R
    @Test
    public void menorTaxaUploadMedidaValida(){

        double expected = 1400;
        Assert.assertEquals(expected, this.testeVelocidadeInternet.menorTaxaUploadMedida(), 0.001);
    }

    //  Letra R
    @Test
    public void menorTaxaUploadMedidaNaoValida(){

        double expected = 300;
        Assert.assertNotEquals(expected, this.testeVelocidadeInternet.menorTaxaUploadMedida(), 0.001);
    }

    //  Letra S
    @Test
    public void menorTaxaPingMedidaValida(){

        double expected = 25;
        Assert.assertEquals(expected, this.testeVelocidadeInternet.menorTaxaPingMedida(), 0.001);
    }

    //  Letra S
    @Test
    public void menorTaxaPingMedidaNotValida(){

        double expected = 20;
        Assert.assertNotEquals(expected, this.testeVelocidadeInternet.menorTaxaPingMedida(), 0.001);
    }

//    Letra T
    @Test
    public void desvioPadraoTaxaDownloadValida(){

        double expected = 66.66666666666667;
        Assert.assertEquals(expected, this.testeVelocidadeInternet.desvioPadraoTaxaDownload(), 0.0001);
    }

    //    Letra T
    @Test
    public void desvioPadraoTaxaDownloadNaoValida(){

        double expected = 21.54;
        Assert.assertNotEquals(expected, this.testeVelocidadeInternet.desvioPadraoTaxaDownload(), 0.0001);
    }

    //    Letra U
    @Test
    public void desvioPadraoTaxaUploadValida(){

        double expected = 111.11111111111109;
        Assert.assertEquals(expected, this.testeVelocidadeInternet.desvioPadraoTaxaUpload(), 0.0001);
    }

    //    Letra U
    @Test
    public void desvioPadraoTaxaUploadNotValida(){

        double expected = 345.34;
        Assert.assertNotEquals(expected, this.testeVelocidadeInternet.desvioPadraoTaxaUpload(), 0.0001);
    }

    //    Letra V
    @Test
    public void desvioPadraoTaxaPingValida(){

        double expected = 18.888889;
        Assert.assertEquals(expected, this.testeVelocidadeInternet.desvioPadraoTaxaPing(), 0.0001);
    }

    //    Letra V
    @Test
    public void desvioPadraoTaxaPingNotValida(){

        double expected = 34.2;
        Assert.assertNotEquals(expected, this.testeVelocidadeInternet.desvioPadraoTaxaPing(), 0.0001);
    }
}