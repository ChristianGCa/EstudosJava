package com.acme.textBlocks;

public class TextBlocks {

    public static void main(String[] args) {

        String texto = "E tudo ficou tão claro\n" +
                       "o que era raro, ficou comum\n" +
                       "como um dia depois do outro\n" +
                       "como um dia, um dia comum...";

        
        String texto2 = """
                        E tudo ficou tão claro
                        o que era raro, ficou comum
                        como um dia depois do outro
                        como um dia, um dia comum...
                        """;
        


        String texto_html = """
                            <html>
                                <head>
                                    Titulo
                                </head>
                                <body>
                                </body>
                            </html>
                            """.indent(16);
        
        System.out.println(texto_html);
    }
    
}
