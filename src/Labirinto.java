public class Labirinto {

    private String[][] mapa = new String[11][10];
    private Personagem personagem;

    public Labirinto(Personagem personagem) {
        this.personagem = personagem;
        setMapaLabirinto();
    }

    public String[][] getMapa() {
        return mapa;
    }

    public Personagem getPersonagem() {
        return personagem;
    }

    private void setMapaLabirinto() {
        for (int c = 0; c < 10; c++) {
            for (int l = 0; l < 11; l++) {

                if (c == 0) {
                    mapa[l][c] = "#";
                    if (l == 9) {
                        mapa[l][c] = "E";
                    }
                }
                if (c == 1) {
                    mapa[l][c] = " ";
                    if (l == 4 || l == 6 || l == 8) {
                        mapa[l][c] = "#";
                    }
                    if (l == 0) {
                        mapa[l][c] = personagem.toString();
                    }
                }
                if (c == 2) {
                    mapa[l][c] = "#";
                    if (l == 1 || l == 3 || l == 5 || l == 7 || l == 10) {
                        mapa[l][c] = " ";
                    }
                }
                if (c == 3) {
                    mapa[l][c] = " ";
                    if (l == 0 || l == 2 || l == 3 || l == 4 || l == 6) {
                        mapa[l][c] = "#";
                    }
                }
                if (c == 4) {
                    mapa[l][c] = " ";
                    if (l == 0 || l == 6 || l == 10) {
                        mapa[l][c] = "#";
                    }
                }
                if (c == 5) {
                    mapa[l][c] = "#";
                    if (l == 1 || l == 7 || l == 9) {
                        mapa[l][c] = " ";
                    }
                }
                if (c == 6) {
                    mapa[l][c] = " ";
                    if (l == 0 || l == 8 || l == 10) {
                        mapa[l][c] = "#";
                    }
                }
                if (c == 7) {
                    mapa[l][c] = "#";
                    if (l == 1 || l == 9) {
                        mapa[l][c] = " ";
                    }
                }
                if (c == 8) {
                    mapa[l][c] = " ";
                    if (l == 0 || l == 6 || l == 7 || l == 8 || l == 10) {
                        mapa[l][c] = "#";
                    }
                }
                if (c == 9) {
                    mapa[l][c] = "#";
                    if (l == 1 || l == 7 || l == 8 | l == 9) {
                        mapa[l][c] = " ";
                    }
                }

            }
        }
    }

    public String mostrarLabirinto() {
        String mapaCordenadas = "";
        for (int l = 0; l < 11; l++) {
            for (int c = 0; c < 10; c++) {
                mapaCordenadas += "|" + mapa[l][c];
            }
            mapaCordenadas += "|\n";
        }
        return mapaCordenadas;
    }

    public Integer getColunaPersonagem(Personagem personagem){
        for (Integer l = 0; l < 11; l++) {
            for (Integer c = 0; c < 10; c++) {
                if(mapa[l][c] == personagem.toString()){
                    return c;
                }
            }
        }
        return null;
    }

    public Integer getLinhaPersonagem(Personagem personagem){
        for (Integer l = 0; l < 11; l++) {
            for (Integer c = 0; c < 10; c++) {
                if(mapa[l][c] == personagem.toString()){
                    return l;
                }
            }
        }
        return null;
    }

    public boolean checarCaminhoLivre(int l, int c){
        if(l >= 0 && l < mapa.length &&
            c >= 0 && c < mapa[l].length){
            if(mapa[l][c] == " " || mapa[l][c] == "E"){
                return true;
            }
        }

        return false;
    }

    public boolean personagemNaSaida(){
        for (Integer l = 0; l < 11; l++) {
            for (Integer c = 0; c < 10; c++) {
                if(mapa[l][c] == "E"){
                    return false;
                }
            }
        }
        return true;
    }

}
