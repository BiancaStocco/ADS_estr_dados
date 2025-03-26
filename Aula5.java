import java.util.Stack;

public class Aula5 {

    /** Método fornecido para testar delimitadores */
    public static boolean isMatched(String expression) {
        Stack<String> buffer = new Stack<>();
        
        // Expressão para procurar tags entre < e >
        int i = 0;
        while (i < expression.length()) {
            if (expression.charAt(i) == '<') {
                int j = expression.indexOf('>', i);
                if (j == -1) {
                    return false; // Se não encontrar o '>', significa erro de sintaxe
                }

                String tag = expression.substring(i + 1, j); // Extrai a tag entre < e >
                if (!tag.startsWith("/")) { // Se for uma tag de abertura
                    buffer.push(tag);
                } else { // Se for uma tag de fechamento
                    if (buffer.isEmpty() || !buffer.peek().equals(tag.substring(1))) {
                        return false; // A tag de fechamento não corresponde
                    }
                    buffer.pop(); // Desempilha a tag correspondente
                }
                i = j + 1; // Continua após o '>'
            } else {
                i++;
            }
        }

        return buffer.isEmpty();
    }


    public static void main(String[] args) {
        String codigo1 = "<body>" +
                         "<center>" +
                         "<h1> The Little Boat </h1>" +
                         "</center>" +
                         "<p> The storm tossed the little " +
                         "boat like a cheap sneaker in an " +
                         "old washing machine. The three " +
                         "drunken fishermen were used to " +
                         "such treatment, of course, but " +
                         "not the tree salesman, who even as " +
                         "a stowaway now felt that he " +
                         "had overpaid for the voyage. </p>" +
                         "<ol>" +
                         "<li> Will the salesman die? </li>" +
                         "<li> What color is the boat? </li>" +
                         "<li> And what about Naomi? </li>" +
                         "</ol>" +
                         "</body>";


        String codigo2 = "<body>" +
                        "<center>" +
                        "<h1>The Little Boat</h1>" +
                        "</center>" +
                        "<p>" +
                        "The storm tossed the little boat like a cheap sneaker in an old washing machine." +
                        "The three drunken fishermen were used to such treatment, of course, but not the tree salesman," +
                        "who even as a stowaway now felt that he had overpaid for the voyage." +
                        "<ol>" +
                        "<li>Will the salesman die?</li>" +
                        "<li>What color is the boat?</li>" +
                        "<li>And what about Naomi?</li>" +
                        "</ol>" +
                        "</body>";



        System.out.printf("Resultado Código 1: %b\n", isMatched(codigo1));
        System.out.printf("Resultado Código 2: %b\n", isMatched(codigo2));
    }
}