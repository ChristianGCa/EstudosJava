package com.acme;

import java.util.HashMap;
import java.util.Set;

public class ExercicioHashMap {

    public static void main(String[] args) {

        String texto = "O professor titular sênior do Programa de Pós-Graduação em Desenvolvimento Regional (PPGDR) da Unijuí, Sérgio Luís Allebrandt, realizou, entre os dias 17 de fevereiro e 2 de março, um intercâmbio acadêmico junto a diversas instituições do Equador. \n"
                + "\n"
                + "Já na primeira semana, entre os dias 19 e 22 de fevereiro, ministrou o Seminário Temático de Desenvolvimento Territorial e Regional para estudantes da Maestria em Gestión Tecnológica e do Doctorado en Gestión Tecnológica da Escuela Politécnica Nacional del Ecuador (EPN). No dia 20, realizou uma reunião com o reitor da EPN, professor doutor Tarquino Sánchez, o professor doutor Efraín Naranjo e a Assessoria de Relações Internacionais da EPN. O objetivo foi avaliar os avanços dos projetos interinstitucionais que vem sendo desenvolvidos entre o PPGDR da Unijuí e o Doctorado en Gestión Tecnológica da EPN, no âmbito do Memorando de Entendimento firmado entre a EPN e a Unijuí em 2019, e prospectar novas atividades entre as duas instituições.\n"
                + "\n"
                + "O reitor da EPN manifestou o interesse em ampliar o intercâmbio com a assinatura do Convênio Marco entre EPN e Unijuí. Manifestou, ainda, interesse da Instituição em ações de mobilidade de estudantes da graduação em diversas áreas do conhecimento e parceria com a Criatec, visando a criação de um Centro de Inovação junto à EPN. Também referendou o interesse em parceria para a implantação de Mestrado (e futuro Doutorado) em Desenvolvimento Regional na EPN, viabilizando intercâmbio de professores, atividades de cotutela e possibilidade de dupla titulação.\n"
                + "\n"
                + "Este último tema também foi discutido em reunião realizada com o coordenador do doutorado em Gestión Tecnológica, professor doutor Oswaldo Viteri, no dia 21 de fevereiro. Nesta reunião, foi definido que, a partir do novo Convênio Marco entre EPN e Unijuí, será firmado um Convênio Aditivo entre os dois Programas (GT/EPN e PPGDR/Unijuí), reafirmando as atividades já previstas no atual convênio e reforçando atividades de cotutela, investigações conjuntas, mobilidade de professores e alunos, organização de eventos e publicações conjuntas.\n"
                + "\n"
                + "No dia 22, foi realizada uma reunião com o decano da Faculdade de Ciências Administrativas da EPN, professor Jaime Cadena, em que foram discutidos diversos temas já abordados nas outras reuniões. O professor Jaime também manifestou interesse especial em estabelecer contato e parceria com o curso de Engenharia da Produção da Unijuí.\n"
                + "\n"
                + "Durante os dias 27, 28 e 29, o professor Sérgio ainda desenvolveu atividades junto ao doutorado em Gestión Tecnológica, com reuniões com doutorandos e participação na reunião do Departamento de Estudos Organizacionais e Desenvolvimento Humano (DESODEH).\n"
                + "\n"
                + "Universidad del Azuay (Cuenca)\n"
                + "\n"
                + "No dia 23 de fevereiro, o professor Sérgio Allebrandt viajou para a cidade de Cuenca, onde realizou contatos na Universidad del Azuay (UDA) - uma instituição de caráter comunitário com características semelhantes à Unijuí. Foi recebido pelo reitor, professor doutor Francisco Salgado Arteaga, pela vice-reitora de Investigação, professora doutora Rafaella Ansaloni, e pelo diretor do Instituto de Estudios de Régimen Seccional del Ecuador (IERSE), professor Omar Delgado Inga.\n"
                + "\n"
                + "O reitor da UDA, professor Francisco, assinou o Convênio Marco entre a UDA e a Unijuí, conforme a proposta encaminhada pela Assessoria de Relações Internacionais da Unijuí. Ressaltou a importância da parceria entre as instituições, manifestando interesse em mobilidade de estudantes da graduação e pós-graduação de ambas as instituições.\n"
                + "\n"
                + "Após a reunião e uma visita a algumas das instalações da UDA, foi realizada uma reunião com a equipe do IERSA, um instituto que vem trabalhando em temas de desenvolvimento territorial com entidades públicas e privadas, com a finalidade de promover o desenvolvimento das regiões por meio do fortalecimento dos governos locais, constituindo-se em importante elo entre a UDA e a sociedade. O diretor do IERSA manifestou especial interesse em parceria na capacitação em Gestão Social e Territorial, visando a promoção da cidadania por meio da disseminação e apropriação pelas comunidades das informações e dados da plataforma que disponibiliza elementos da fotogrametria arquitetural do patrimônio, inventário florestal de parques urbanos, planificação territorial, medição e monitoramento de ruído ambiental etc.\n"
                + "\n"
                + "Corporação Grupo Salinas – Salinas de Guaranda\n"
                + "\n"
                + "No dia 26 de fevereiro, juntamente com o professor Efrain Naranjo, da EPN, o professor Sérgio realizou uma viagem a Salinas de Guaranda, região que fica a mais de 4.000 metros de altura, nos Andes, para conhecer uma experiência exitosa de desenvolvimento territorial iniciada há mais de 50 anos. \n"
                + "\n"
                + "Recebidos pelo padre Antonio Polo, principal articulador e responsável pelo projeto desde seu início, foi possível participar da reunião de articulação semanal dos principais dirigentes e envolvidos nesta experiência. Desde 1970, Salinas apostou no cooperativismo como forma efetiva e democrática de enfrentar a pobreza e a marginalização. Pouco a pouco, o local passou de um povo sem cultura organizativa e produtora de sal para um povo organizado e agroindustrial, convertendo-se em referência para a província e para o país. \n"
                + "\n"
                + "Reunindo mais de 1.200 pequenos agricultores e campesinos, hoje organiza-se na Corporação Grupo Salinas, que reúne Cooperativa de Poupança e Crédito Salinas, Associação Desenvolvimento Social de Artesãos Têxteis de Salinas, Fundação de Organizações Campesinas de Salinas, Fundação Grupo Juvenil de Salinas, Fundação Família Salesiana Salinas e Cooperativa de Produção Agropecuárias El Salinerito. \n"
                + "\n"
                + "Tendo como fundamento as bases da economia popular e solidária e o desenvolvimento sustentável mediante a autogestão, Salinas atualmente abastece o mercado interno e exporta para diversos países europeus e para os Estados Unidos. Entre seus produtos, encontram-se diversos tipos de queijos, chocolates, leite, embutidos, produção têxtil, etc. Conta, ainda, com uma Rádio Comunitária. Recebe voluntários, especialmente estudantes de graduação de diferentes áreas, que realizam trabalho voluntário durante um ano, interrompendo seus estudos na universidade durante este período.";

        texto = texto.toLowerCase().replace(",","").replace(".", "");
        
        System.out.println( "Caracteres -> "+texto.length() );
        
        String[] tokens = texto.split(" ");
        System.out.println( "# Tokens -> "+tokens.length );
        
        HashMap<String, Integer> palavras = buildMap(tokens);
        
        Set<String> keys = palavras.keySet();
        for (String k : keys) {
            System.out.println(k+" ---> "+palavras.get(k));
        }
        
        
        
        
    } // fim main
    
    private static HashMap<String, Integer> buildMap(String[] tokens) {
        
        HashMap<String,Integer> m = new HashMap();
        
        for(String t : tokens) {
            if (m.containsKey(t)) {
                int n = m.get(t);
                m.put(t, ++n);
            }else {
                m.put(t, 1);
            }
        }
        
        return m;
    }
    

}
