package com.example.obrestdatajpa;

import com.example.obrestdatajpa.entidades.Computadora;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.example.obrestdatajpa.repositorios.ComputadoraReposity;

@SpringBootApplication
public class ObRestDatajpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ObRestDatajpaApplication.class, args);

		ComputadoraReposity reposityCom= context.getBean(ComputadoraReposity.class);

		//crear
		Computadora compu1 = new Computadora(null,"exo","smart",2010);
		Computadora compu2 = new Computadora(null,"exo","gala",2015);

		//almacenar
		System.out.println("num de computadoras: "+reposityCom.findAll().size());

		reposityCom.save(compu1);
		reposityCom.save(compu2);

		//recuperar todos

		System.out.println("num de computadoras: "+reposityCom.findAll().size());

		//borrar
		//reposityCom.deleteById(1L);

		System.out.println("num de computadoras: "+reposityCom.findAll().size());
		//



	}

}
