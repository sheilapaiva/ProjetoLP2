package projetoLP2;

import java.util.HashMap;

public class ControleProjetos {

    public HashMap<String, Projetos> projetos = new HashMap<>();



    public String cadastraPl(String dni, int ano, String ementa, String interesses, String url, boolean conclusivo){
       int numProjeto = projetos.size() + 1;
       Pessoa autor = new ControlePessoa().getMapPessoa().get(dni);
       Projetos projeto = new Pl(autor,ano,ementa,interesses,url,conclusivo);
       String codigo = "PL "+Integer.toString(numProjeto) +"/"+projeto.getAno();
       projetos.put(codigo, projeto);
       return "Projeto de Lei - "+ codigo + " - " + dni + projetos.get(codigo).toString();

    }

    public String cadastraPLP(String dni, int ano, String ementa, String interesses, String url, String artigos){
        int numProjeto = projetos.size()+1;
        Pessoa autor = new ControlePessoa().getMapPessoa().get(dni);
        Projetos projeto = new Plp(autor,ano,ementa,interesses,url,artigos);
        String codigo = "PLP " + Integer.toString(numProjeto)+"/"+projeto.getAno();
        projetos.put(codigo, projeto);
        return "Projeto de Lei Complementar - "+ codigo + " - "+ dni + projetos.get(codigo).toString();
    }




}
