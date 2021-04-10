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

    public TesteVelocidadeInternet(){
        this.medicoes = new ArrayList<>();
    }

    public int totalMedicoes(){
        return this.medicoes.size();
    }

    public double mediaDownload(){
        return this.medicoes.stream().mapToDouble(medicao -> medicao.getTaxaDownload()).average().orElse(0.0);
    }

    public double mediaUpload(){
        return this.medicoes.stream().mapToDouble(medicao -> medicao.getTaxaUpload()).average().orElse(0.0);
    }

    public double mediaPings(){
        return this.medicoes.stream().mapToDouble(medicao -> medicao.getPing()).average().orElse(0.0);
    }

    public long totalDownloadsInferiorTaxaDesejeda(){
        return this.medicoes.stream().filter(medicao -> medicao.getTaxaDownload() < this.downloadDesejado).count();
    }

    public long totalUploadsInferiorTaxaDesejeda(){
        return this.medicoes.stream().filter(medicao -> medicao.getTaxaUpload() < this.uploadDesejado).count();
    }

    public long totalPingSuperiorTaxaDesejeda(){
        return this.medicoes.stream().filter(medicao -> medicao.getPing() > this.pingDesejado).count();
    }

    public long percentualDownloadsInferiorTaxaDesejeda(){
        long inferior = totalUploadsInferiorTaxaDesejeda();
        int total = totalMedicoes();
        return inferior / total;
    }

    public long percentualUploadsInferiorTaxaDesejeda(){
        long inferior = totalDownloadsInferiorTaxaDesejeda();
        int total = totalMedicoes();
        return inferior / total;
    }

    //    até a letra I mas sem testar nada ainda

    public void adicionarMedicao(Medicao medicao){
        this.medicoes.add(medicao);
    }

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

    public List<Medicao> getMedicoes() {
        return medicoes;
    }
}
