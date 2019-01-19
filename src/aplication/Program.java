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
					System.out.println("Digite o nome: "); String name = sc.nextLine();
					int enumClient=0;
					int cont=0;
					for (Clients obj : client) {
						if(obj.getName()==name) {
							enumClient=cont;
						}
						cont++;
					}

					if(enumClient>=0) {
						int auxCli=0;
						System.out.println("0.Dados cliente");
						System.out.println("1.Adicionar ordem de compra");
						System.out.println("2.Vizualizar dados da compra");
						System.out.println("3.Cancelar");
						auxCli=sc.nextInt();
						
						switch (auxCli) {
							case 0:
								System.out.println(client.get(enumClient).toString());
								break;
							case 1:
								Order ord = new Order();
								System.out.println("Enter order data: ");
								sc.nextLine();
								System.out.println("Id: "); ord.setId(sc.nextLine());
								System.out.println("Status: "); ord.setStatus(sc.nextLine());
								
								System.out.println("How many items to this order?"); int numProd = sc.nextInt();
								
								for(int i=0;i<numProd;i++) {
									OrderItem ordIte = new OrderItem();
									Product prod = new Product();
									System.out.println("Enter #"+i+" item data:");
									System.out.println("id order: "); ordIte.setId(sc.nextLine());
									System.out.println("Product name: "); prod.setName(sc.nextLine());
									System.out.println("Product price: "); Double priceProd =sc.nextDouble();
									System.out.println("Quantity: "); ordIte.setQuantity(sc.nextInt());

									prod.setPrice(priceProd);
									ordIte.setPrice(priceProd);

									ordIte.setProd(prod);
									
									ord.addOrderProducts(ordIte);
								}
								client.get(enumClient).addRequests(ord);
								break;
								
							case 2:
								System.out.println("Enter id order: "); String search= sc.nextLine();
								client.get(enumClient).getReqauest(search).toString();
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
		sc.close();
	}

}
