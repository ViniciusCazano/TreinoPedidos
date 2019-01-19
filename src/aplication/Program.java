package aplication;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Clients;
import entities.Order;
import entities.OrderItem;
import entities.Product;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc =  new Scanner(System.in);
		List<Clients> client = new ArrayList<>();
		int aux=0;
		while(aux>=0) {
			System.out.println("0.Salvar cliente");
			System.out.println("1.Pesquisar cliente");
			System.out.println("2.Sair");
			aux=sc.nextInt();
			sc.nextLine();
			switch(aux) {
				case 0:
					Clients cli =  new Clients();
					System.out.println("Enter cliente data:");
					System.out.println("Name: "); cli.setName(sc.nextLine());
					System.out.println("Email: ");cli.setEmail(sc.nextLine());
					System.out.println("BirthDate: "); cli.setBirthDate(sc.nextLine());
					client.add(cli);
					break;
				case 1:
					sc.nextLine();
					System.out.println("Digite o nome: "); String name = sc.nextLine();
					int enumClient = client.indexOf(name);
					
					if(enumClient>=0) {
						int auxCli=0;
						System.out.println("0.Dados cliente");
						System.out.println("1.Adicionar ordem de compra");
						System.out.println("2.Vizualizar dados da compra");
						System.out.println("3.Cancelar");
						auxCli=sc.nextInt();
						
						switch (auxCli) {
							case 0:
								client.get(enumClient).toString();
								break;
							case 1:
								System.out.println("Enter order data: ");
								System.out.println("Id: "); String id = sc.nextLine();
								System.out.println("Status: "); String status = sc.nextLine();
								Order ord = new Order();
								ord.setId(id);
								ord.setMoment();
								ord.setStatus(status);
								client.get(enumClient).addRequests(ord);
								System.out.println("How many items to this order?"); int numProd = sc.nextInt();
								
								for(int i=0;i<numProd;i++) {
									OrderItem ordIte = new OrderItem();
									Product prod = new Product();
									System.out.println("Enter #"+i+" item data:");
									System.out.println("id order: "); String idOrd = sc.nextLine();
									System.out.println("Product name: "); String nameProd = sc.nextLine();
									System.out.println("Product price: "); Double priceProd =sc.nextDouble();
									System.out.println("Quantity: "); Integer quantityProd = sc.nextInt();
									ordIte.setId(idOrd);
									ordIte.setPrice(priceProd);
									ordIte.setQuantity(quantityProd);
									prod.setName(nameProd);
									prod.setPrice(priceProd);
									ordIte.setProd(prod);
									
								}
								break;
						}
						
					}
					else {
						System.out.println("Cliente nao encontrado");
					}
					break;
					
					
				default:
					System.out.println("Escolha invalida");
					break;

			}
		}
	}

}
