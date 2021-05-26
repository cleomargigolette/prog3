package com.company;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TesteVelocidadeInternet {

    private LocalDate data;
    private String nomeProvedor;
    private List<Medicao> medicoes;
    private double pingDesejado;
    private double downloadDesejado;
    private double uploadDesejado;

    public TesteVelocidadeInternet() {
        this.medicoes = new ArrayList<Medicao>();
    }

    //  a. Um método que retorna a quantidade total de medições;
    public int totalMedicoes() {
        return this.medicoes.size();
    }

//  b. Um método que retorna a média das taxas de download medidas;

    public double mediaDownload() {
        return this.medicoes.stream()
                .mapToDouble(medicao -> medicao.getTaxaDownload()).average().orElse(0.0);
    }

//  c. Um método que retorna a média das taxas de upload medidas;
    public double mediaUpload() {
        return this.medicoes.stream()
                .mapToDouble(medicao -> medicao.getTaxaUpload()).average().orElse(0.0);
    }

//  d. Um método que retorna a média das taxas de ping medidas;
    public double mediaPings() {
        return this.medicoes.stream()
                .mapToDouble(medicao -> medicao.getPing()).average().orElse(0.0);
    }

//  e. Um método que retorna a quantidade de taxas de download medidas inferiores à taxa  desejada;
    public long totalDownloadsInferioresTaxaDesejeda() {
        return this.medicoes.stream()
                .filter(medicao -> medicao.getTaxaDownload() < this.downloadDesejado)
                .count();
    }
//  f. Um método que retorna a quantidade de taxas de upload medidas inferiores à taxa desejada;
    public long totalUploadsInferioresTaxaDesejeda() {
        return this.medicoes.stream()
                .filter(medicao -> medicao.getTaxaUpload() < this.uploadDesejado)
                .count();
    }

//  g. Um método que retorna a quantidade de taxas de ping medidas que são superiores à taxa  desejada;
    public long totalPingSuperioresTaxaDesejeda() {
        return this.medicoes.stream()
                .filter(medicao -> medicao.getPing() > this.pingDesejado)
                .count();
    }

//  h. Um método que retorna o percentual de taxas de download inferiores à taxa desejada  (quantidade de taxas de download inferiores / total de medições).
    public double percentualDownloadsInferioresTaxaDesejeda() {

        long downloadsInferiores = this.totalDownloadsInferioresTaxaDesejeda();
        int total = totalMedicoes();

        return Double.valueOf(downloadsInferiores) / Double.valueOf(total);
    }

//  i. Um método que retorna o percentual de taxas de upload inferiores à taxa desejada (quantidade  de taxas de upload inferiores / total de medições).
    public double percentualUploadsInferioresTaxaDesejeda() {

        long upoadsInferiores = this.totalUploadsInferioresTaxaDesejeda();
        int total = totalMedicoes();

        return Double.valueOf(upoadsInferiores) / Double.valueOf(total);
    }

//  j. Um método que retorna o percentual de taxas de ping superiores à taxa desejada (quantidadede taxas de ping inferiores / total de medições);
    public double percentualPingsSuperioresTaxaDesejada() {

        long superior = this.totalPingSuperioresTaxaDesejeda();
        int total = this.totalMedicoes();

        return Double.valueOf(superior) / Double.valueOf(total);
    }
//  k. Um método que retorna o valor true se o percentual de taxas de download inferiores à taxa desejada for menor que 20%. Senão, retorna o valor false.
    public Boolean taxaDownloadInferioresTaxaDesejadaMenor20Porcento(){
        return this.percentualDownloadsInferioresTaxaDesejeda() < 20 ? true : false;
    }

//  l. Um método que retorna o valor true se o percentual de taxas de upload inferiores à taxa desejada for menor que 20%. Senão, retorna o valor false.
    public Boolean taxaUploadInferioresTaxaDesejadaMenor20Porcento(){
        return this.percentualUploadsInferioresTaxaDesejeda() < 20 ? true : false;
    }

//  m. Um método que retorna o valor true se o percentual de taxas de ping superiores à taxa desejada for menor que 20%. Senão, retorna o valor false.
    public Boolean  taxaPingSuperioresTaxaDesejadaMenor20Porcento(){
        return this.percentualPingsSuperioresTaxaDesejada() < 20 ? true : false;
    }

//  n. Um método que retorna a maior taxa de download medida;
    public double maiorTaxaDownloadMedida(){
        return this.medicoes.stream().mapToDouble(Medicao::getTaxaDownload).max().orElse(0);
    }

//  o. Um método que retorna a maior taxa de upload medida;
    public double maiorTaxaUploadMedida(){
        return this.medicoes.stream().mapToDouble(Medicao::getTaxaUpload).max().orElse(0);
    }

//  p. Um método que retorna a maior taxa de ping medida.
    public double maiorTaxaPingMedida(){
        return this.medicoes.stream().mapToDouble(Medicao::getPing).max().orElse(0);
    }

//  q. Um método que retorna a menor taxa de download medida;
    public double menorTaxaDownloadMedida(){
        return this.medicoes.stream().mapToDouble(Medicao::getTaxaDownload).min().orElse(0);
    }

//  r. Um método que retorna a menor taxa de upload medida;
    public double menorTaxaUploadMedida(){
        return this.medicoes.stream().mapToDouble(Medicao::getTaxaUpload).min().orElse(0);
    }

//  s. Um método que retorna a menor taxa de ping medida.
    public double menorTaxaPingMedida(){
        return this.medicoes.stream().mapToDouble(Medicao::getPing).min().orElse(0);
    }

//  t. Um método que retorna o desvio padrão das taxas de download medidas.
    public double desvioPadraoTaxaDownload(){

        double mediaTaxaDownload = this.mediaDownload();
        List<Double> valorAbsolutoList = new ArrayList<>();

        for (Medicao medicao : this.medicoes) {
            double resultadoTemp = mediaTaxaDownload - medicao.getTaxaDownload();
            valorAbsolutoList.add(Math.abs(resultadoTemp));
        }

        double totalValorAbsoluto = valorAbsolutoList.stream().mapToDouble(Double::doubleValue).sum();
        return totalValorAbsoluto / this.totalMedicoes();
    }

//  u. Um método que retorna o desvio padrão das taxas de upload medidas.
    public double desvioPadraoTaxaUpload(){

        double mediaTaxaUpload = this.mediaUpload();
        List<Double> valorAbsolutoList = new ArrayList<>();

        for (Medicao medicao : this.medicoes) {
            double resultadoTemp = mediaTaxaUpload - medicao.getTaxaUpload();
            valorAbsolutoList.add(Math.abs(resultadoTemp));
        }

        double totalValorAbsoluto = valorAbsolutoList.stream().mapToDouble(Double::doubleValue).sum();
        return totalValorAbsoluto / this.totalMedicoes();
    }

//  v. Um método que retorna o desvio padrão das taxas de ping medidas.
    public double desvioPadraoTaxaPing(){

        double mediaTaxaPing = this.mediaPings();
        List<Double> valorAbsolutoList = new ArrayList<>();

        for (Medicao medicao : this.medicoes) {
            double resultadoTemp = mediaTaxaPing - medicao.getPing();
            valorAbsolutoList.add(Math.abs(resultadoTemp));
        }

        double totalValorAbsoluto = valorAbsolutoList.stream().mapToDouble(Double::doubleValue).sum();
        return totalValorAbsoluto / this.totalMedicoes();
    }

    //  método para adicionar as medições
    public void adicionarMedicao(Medicao medicao) {
        this.medicoes.add(medicao);
    }

    //  getters e setters
    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getNomeProvedor() {
        return nomeProvedor;
    }

    public void setNomeProvedor(String nomeProvedor) {
        this.nomeProvedor = nomeProvedor;
    }

    public List<Medicao> getMedicoes() {
        return medicoes;
    }

    public double getPingDesejado() {
        return pingDesejado;
    }

    public void setPingDesejado(double pingDesejado) {
        this.pingDesejado = pingDesejado;
    }

    public double getDownloadDesejado() {
        return downloadDesejado;
    }

    public void setDownloadDesejado(double downloadDesejado) {
        this.downloadDesejado = downloadDesejado;
    }

    public double getUploadDesejado() {
        return uploadDesejado;
    }

    public void setUploadDesejado(double uploadDesejado) {
        this.uploadDesejado = uploadDesejado;
    }
}
