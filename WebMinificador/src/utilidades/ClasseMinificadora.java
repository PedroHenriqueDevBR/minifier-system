package utilidades;

public class ClasseMinificadora {
    public String minificaHtml(String linha){
        boolean eliminar = false;
        String resultado = "";
        
        String letras[] = linha.split("");

        int limite = letras.length;

        for (int posicao = 0; posicao < limite; posicao++){
            if (eliminar){
                if (letras[posicao].equals(">") && letras[posicao - 1].equals("-")){
                    eliminar = false;
                    continue;
                } else {
                    continue;
                }

            } else {
                if (letras[posicao].equals("<") && letras[posicao + 1].equals("!")){
                    if (letras[posicao + 2].equals("D") || letras[posicao + 2].equals("d")){
                        eliminar = false;
                    } else {
                        eliminar = true;
                        continue;
                    }
                }
            }

            if (letras[posicao].equals("\n") || letras[posicao].equals("\t")){
                continue;
            }

            resultado += letras[posicao];

        }
        
        return resultado;
    }
    
    public String minificaCss(String linha){
        boolean eliminar = false;
        String resultado = "";
        
        String letras[] = linha.split("");

        int limite = letras.length;

        for (int posicao = 0; posicao < limite; posicao++){
            if (eliminar){
                if (letras[posicao].equals("/") && letras[posicao - 1].equals("*")){
                    eliminar = false;
                    continue;
                } else {
                    continue;
                }

            } else {
                if (letras[posicao].equals("/") && letras[posicao + 1].equals("*")){
                    eliminar = true;
                    continue;
                }
            }

            if (letras[posicao].equals("\n") || letras[posicao].equals("\t")){
                continue;
            }

            resultado += letras[posicao];

        }
        
        return resultado;
    }
    
    public String minificaJs(String linha){
        boolean eliminar = false;
        boolean eliminaDois = false;
        String resultado = "";
        
        String letras[] = linha.split("");

        int limite = letras.length;

        for (int posicao = 0; posicao < limite; posicao++){
            if (eliminar){
                if (letras[posicao].equals("/") && letras[posicao - 1].equals("*")){
                    eliminar = false;
                    continue;
                } else {
                    continue;
                }

            } else {
                if (letras[posicao].equals("/") && letras[posicao + 1].equals("*")){
                    eliminar = true;
                    continue;
                }
            }
            
            // Segunda verificação
            if (eliminaDois){
                if (letras[posicao].equals("\n")){
                    eliminaDois = false;
                    continue;
                } else {
                    continue;
                }

            } else {
                if (letras[posicao].equals("/") && letras[posicao + 1].equals("/") && !eliminar){
                    eliminaDois = true;
                    continue;
                }
            }
            
            // Última verificação
            if (letras[posicao].equals("\n") || letras[posicao].equals("\t")){
                continue;
            }

            resultado += letras[posicao];

        }
        
        return resultado;
    }
    
}
