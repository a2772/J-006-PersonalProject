package com.paris.modelo.utilerias;

import java.time.LocalDate;

public class GeneraCurp {
    // <editor-fold defaultstate="collapsed" desc="Métodos utilizables externos">
    /**
     * Genera un CURP propuesto en función de los datos proporcionados. En caso de no encontrar algún caracter o que falte en los nombres, se marcará con *
     * @param nombres Nombre o nombres del individuo
     * @param primerApellido Primer apellido
     * @param segundoApellido Segundo apellidd
     * @param fechaNac Fecha de nacimiento del individuo
     * @param sexo Obtener de la clase Dictionary
     * @param cveEntidad Clave de la entidad federativa a la cual pertenece el individuo (2 caracteres)
     * @param ultimos2Valores Los últimos 2 caracteres de la CURP
     * @return la CURP generada
     */
    public static String substraeCurp(String nombres, String primerApellido, String segundoApellido,
            LocalDate fechaNac, String sexo, String cveEntidad, String ultimos2Valores) {
        //Variables
        StringBuilder curp = new StringBuilder();
        curp.append(primerApellido.charAt(0));
        curp.append(getFirstVowel(primerApellido));//Elementos del CURP 2/18
        curp.append(segundoApellido.charAt(0));//Elementos del CURP 3/18
        curp.append(nombres.charAt(0));//Elementos del CURP 4/18
        curp.append(String.valueOf(fechaNac.getYear()).substring(2, 4)); //Elementos del CURP 6/18
        curp.append(fechaNac.getMonthValue() < 10 ? "0" : "");
        curp.append(fechaNac.getMonthValue()); //Elementos del CURP 8/18
        curp.append(fechaNac.getDayOfMonth() < 10 ? "0" : "");
        curp.append(fechaNac.getDayOfMonth()); //Elementos del CURP 10/18
        curp.append(sexo.charAt(0));//Elementos del CURP 11/18
        curp.append(cveEntidad);//Elementos del CURP 13/18
        curp.append(getFirstConsonant(primerApellido.substring(1)));//Elementos del CURP 14/18
        curp.append(getFirstConsonant(segundoApellido.substring(1)));//Elementos del CURP 15/18
        curp.append(getFirstConsonant(nombres.substring(1)));//Elementos del CURP 16/18
        curp.append(ultimos2Valores);
        return curp.toString();
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Métodos internos">
    
    /**
     * Busca la primera vocal de una palabra
     *
     * @param palabra
     * @return La primera vocal encontrada en la palabra. Si no se encuentra, se
     * devuelve un *
     */
    private static char getFirstVowel(String palabra) {
        int indexOfVowel = -1;
        for (int busqueda = 0; busqueda < palabra.length(); busqueda ++) {
            switch (palabra.toUpperCase().charAt(busqueda)) {
                case 'A':
                case 'E':
                case 'I':
                case 'O':
                case 'U':
                case 'Á':
                case 'É':
                case 'Í':
                case 'Ó':
                case 'Ú':
                    indexOfVowel = busqueda;
                    break;
            }
            if(indexOfVowel == busqueda){
                break;//Si se encontró, salimos del for
            }
        }
        return indexOfVowel != -1 ? palabra.charAt(indexOfVowel) : '*';//Si se encontró la devolvemos, sino devolvemos *
    }

    /**
     * Busca la primera consonante de una palabra
     *
     * @param palabra
     * @return La primera consonante encontrada en la palabra. Si no se
     * encuentra, se devuelve un *
     */
    private static char getFirstConsonant(String palabra) {
        int indexOfConsonant = -1;
        for (int busqueda = 0; busqueda < palabra.length(); busqueda ++) {
            char caracterPosicion = palabra.toUpperCase().charAt(busqueda);
            if(getFirstVowel(String.valueOf(caracterPosicion)) == -1 && caracterPosicion > 65 && caracterPosicion <= 90){
                indexOfConsonant = busqueda;
                break;//Salimos del for
            }
        }
        return indexOfConsonant != -1 ? palabra.charAt(indexOfConsonant) : '*';//Si se encontró la devolvemos, sino devolvemos *
    }
    // </editor-fold>
}
