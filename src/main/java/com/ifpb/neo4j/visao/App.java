package com.ifpb.neo4j.visao;

import org.neo4j.driver.*;
import org.neo4j.driver.summary.ResultSummary;

import java.time.LocalDateTime;

import static org.neo4j.driver.Values.parameters;

public class App {

    public static void main(String[] args) {

        Driver driver = GraphDatabase.driver(
            "bolt://localhost:7687",
            AuthTokens.basic("neo4j","123456"));

        try(Session session = driver.session()){
//            Result result = session.run("CREATE (:Pessoa{" +
//                    "cpf:$cpf, nome:$nome, idade:$idade})",
//                    parameters("cpf", "222.222.222-02",
//                            "nome", "Maria", "idade", 19));
//            ResultSummary summary = result.consume();
//            System.out.println(summary.counters().nodesCreated());

//            Result result = session.run(
//                    "MATCH (p1:Pessoa{cpf:$cpf}), (p2:Pessoa{cpf:$cpf2})" +
//                        " CREATE (p1)-[:AMIGO{desde:$desde}]->(p2)",
//                    parameters("cpf", "111.111.111-01",
//                            "cpf2", "222.222.222-02",
//                            "desde", LocalDateTime.now()));
//
//            System.out.println(result.consume().counters()
//                    .relationshipsCreated());

//            Result result = session.run("MATCH (p:Pessoa) RETURN p");
//            result.stream().forEach(r -> System.out.println(
//                    r.get("p").asNode().asMap()));

            Result result = session.run("MATCH (p:Pessoa) RETURN p.nome");
            result.stream().forEach(r -> System.out.println(r.asMap()));

        }

        driver.close();

    }

}
