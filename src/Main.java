import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        Random random = new Random();

        VipRoom vipRoom = new VipRoom( 20, 0);
        VipRoom newVipRoom = new VipRoom();
        NormalRoom normalRoom = new NormalRoom(30, 0);
        NormalRoom newNormalRoom = new NormalRoom();
        Adm newAdm = new Adm();
        HotelServer allServer = new HotelServer();

        List<HotelServer> clients = new ArrayList<>();

        int resposta;
        int formaPagamento;
        int parcela;
        int qtdParcela;
        int loop;
        int opcaoCheck;
        int checkOutTipoQuarto;
        int checkInTipoQuarto;

        int qtdVipRoomAvailable = vipRoom.getAvailableRoom();
        int qtdVipRoomUnavailable = vipRoom.getUnavailableRoom();
        int qtdNormalRoomAvailable = normalRoom.getAvailableRoom();
        int qtdNormalRoomUnavailable = normalRoom.getUnavailableRoom();

        do {
            System.out.println("Olá, em que posso ajudar?");
            System.out.println("1 --- Fazer checkin");
            System.out.println("2 --- Fazer checkout");
            System.out.println("3 --- ADM");
            resposta = entrada.nextInt();
            entrada.nextLine();

            if (resposta == 1) {
                Client newClient = new Client();
                System.out.println("Digite seu nome: ");
                newClient.setFirstName(entrada.nextLine());
                System.out.println("Digite seu sobrenome: ");
                newClient.setLastName(entrada.nextLine());
                System.out.println("Digite seu CPF: ");
                newClient.setCpf(entrada.nextLong());
                System.out.println("Digite seu RG: ");
                newClient.setRg(entrada.nextLong());
                allServer.addCheckIn(newClient);
                clients.add(allServer);

                System.out.println("Temos " + (qtdVipRoomAvailable + qtdNormalRoomAvailable) + " quartos dinsponíveis");
                System.out.println(qtdVipRoomAvailable + " Quartos VIP");
                System.out.println(qtdNormalRoomAvailable + " Quartos CASUAIS");
                System.out.println("Qual quarto gostaria?");
                System.out.println("1 --- VIP | R$230,50");
                System.out.println("2 --- CASUAL | R$150,50");
                checkInTipoQuarto = entrada.nextInt();

                System.out.println("Quantos dias gostaria de ficar hospedado?");

                if (checkInTipoQuarto == 1){
                    qtdVipRoomAvailable--;
                    qtdVipRoomUnavailable++;
                    newVipRoom.setDays(entrada.nextInt());
                    System.out.println("Perfeito, reserva finalizada!");
                    System.out.println("------------------------------");
                    System.out.println("Nome completo: " + newClient.getFullName());
                    System.out.println("CPF: " + newClient.getCpf());
                    System.out.println("RG: " + newClient.getRg());
                    int quarto = random.nextInt(100);
                    System.out.println("Número do quarto VIP: " + quarto);
                    System.out.println("Valor total parcial: R$" + newVipRoom.valorTotal());
                    System.out.println("------------------------------");
                    System.out.println(newClient.endService());
                } else if(checkInTipoQuarto == 2){
                    qtdNormalRoomAvailable--;
                    qtdNormalRoomUnavailable++;
                    newNormalRoom.setDays(entrada.nextInt());
                    System.out.println("Perfeito, reserva finalizada!");
                    System.out.println("------------------------------");
                    System.out.println("Nome completo: " + newClient.getFullName());
                    System.out.println("CPF: " + newClient.getCpf());
                    System.out.println("RG: " + newClient.getRg());
                    int quarto = random.nextInt(100);
                    System.out.println("Número do quarto CASUAL: " + quarto);
                    System.out.println("Valor total parcial: R$" + newNormalRoom.valorTotal());
                    System.out.println("------------------------------");
                    System.out.println(newClient.endService());
                }
            } else if (resposta == 2) {
                Client newClient = new Client();
                System.out.println("Digite seu nome: ");
                newClient.setFirstName(entrada.nextLine());
                System.out.println("Digite seu sobrenome: ");
                newClient.setLastName(entrada.nextLine());
                System.out.println("Digite seu CPF: ");
                newClient.setCpf(entrada.nextLong());
                System.out.println("Digite seu RG: ");
                newClient.setRg(entrada.nextLong());
                allServer.addCheckOut(newClient);
                clients.add(allServer);
                System.out.println("Qual quarto ficou hospedado?");
                System.out.println("1 --- Quarto VIP");
                System.out.println("2 --- Quarto CASUAL");
                checkOutTipoQuarto = entrada.nextInt();
                System.out.println("Quantos dias ficou hospedado?");
                if (checkOutTipoQuarto == 1){

                    qtdVipRoomAvailable++;
                    qtdVipRoomUnavailable--;
                    newVipRoom.setDays(entrada.nextInt());
                    System.out.println("Valor total: R$" + newVipRoom.valorTotal());
                    System.out.println("------------------------------");
                    System.out.println("Qual a forma de pagamento? ");
                    System.out.println("1 --- Cartão de crédito");
                    System.out.println("2 --- Cartão de débito (10% de desconto)");
                    System.out.println("3 --- Dinheiro (20% de desconto)");
                    formaPagamento = entrada.nextInt();

                    switch (formaPagamento) {
                        case 1:
                            System.out.println("Deseja parcelar?");
                            System.out.println("1 --- sim");
                            System.out.println("2 --- não");
                            parcela = entrada.nextInt();
                            if (parcela == 1) {
                                System.out.println("Em quantas vezes?");
                                qtdParcela = entrada.nextInt();
                                System.out.println("Nome: " + newClient.getFirstName()
                                        + " " + newClient.getLastName()
                                        + " | "
                                        + "Valor total: R$"
                                        + (newVipRoom.valorTotal() / qtdParcela));
                                System.out.println("------------------------------");
                                System.out.println(newClient.endService());
                            } else if (parcela == 2) {
                                System.out.println("Nome: " + newClient.getFirstName()
                                        + " " + newClient.getLastName()
                                        + " | "
                                        + "Valor final: R$"
                                        + (newVipRoom.valorTotal()));
                                System.out.println("------------------------------");
                                System.out.println(newClient.endService());
                            }
                            break;
                        case 2:
                            System.out.println("Nome: " + newClient.getFirstName()
                                    + " " + newClient.getLastName()
                                    + " | "
                                    + "Valor total: R$"
                                    + (newVipRoom.valorTotal() * 0.9));
                            System.out.println("------------------------------");
                            System.out.println(newClient.endService());
                            break;
                        case 3:
                            System.out.println("Nome: " + newClient.getFirstName()
                                    + " " + newClient.getLastName()
                                    + " | "
                                    + "Seu valor total ficou: R$"
                                    + (newVipRoom.valorTotal() * 0.8));
                            System.out.println("------------------------------");
                            System.out.println(newClient.endService());
                            break;
                    }
                } else if(checkOutTipoQuarto == 2){
                    qtdNormalRoomAvailable++;
                    qtdNormalRoomUnavailable--;
                    newNormalRoom.setDays(entrada.nextInt());
                    System.out.println("Valor total: R$" + newNormalRoom.valorTotal());
                    System.out.println("Qual a forma de pagamento? ");
                    System.out.println("1 --- Cartão de crédito");
                    System.out.println("2 --- Cartão de débito (10% de desconto)");
                    System.out.println("3 --- Dinheiro (20% de desconto)");
                    formaPagamento = entrada.nextInt();

                    switch (formaPagamento) {
                        case 1:
                            System.out.println("Deseja parcelar?");
                            System.out.println("1 --- sim");
                            System.out.println("2 --- não");
                            parcela = entrada.nextInt();
                            if (parcela == 1) {
                                System.out.println("Em quantas vezes?");
                                qtdParcela = entrada.nextInt();
                                System.out.println("Nome: " + newClient.getFirstName()
                                        + " " + newClient.getLastName() + " | "
                                        + "Valor total: R$"
                                        + (newNormalRoom.valorTotal() / qtdParcela));
                                System.out.println("------------------------------");
                                System.out.println(newClient.endService());
                            } else if (parcela == 2) {
                                System.out.println("Nome: " + newClient.getFirstName()
                                        + " " + newClient.getLastName()
                                        + " | "
                                        + "Valor final: R$"
                                        + (newNormalRoom.valorTotal()));
                                System.out.println("------------------------------");
                                System.out.println(newClient.endService());
                            }
                            break;
                        case 2:
                            System.out.println("Nome: " + newClient.getFirstName()
                                    + " " + newClient.getLastName()
                                    + " | "
                                    + "Valor total: R$"
                                    + (newNormalRoom.valorTotal() * 0.9));
                            System.out.println("------------------------------");
                            System.out.println(newClient.endService());
                            break;
                        case 3:
                            System.out.println("Nome: " + newClient.getFirstName()
                                    + " " + newClient.getLastName()
                                    + " | "
                                    + "Seu valor total ficou: R$"
                                    + (newNormalRoom.valorTotal() * 0.8));
                            System.out.println("------------------------------");
                            System.out.println(newClient.endService());
                            break;
                    }
                }
            } else if(resposta == 3){
                System.out.println("Qual seu usuário?");
                newAdm.setUserID(entrada.nextLine());
                System.out.println("Qual sua senha?");
                newAdm.setPassword(entrada.nextLine());
                System.out.println("Olá senhor(a) " + newAdm.getUserID() + ". Em que posso ajudar?");
                System.out.println("1 --- Ver CheckIn");
                System.out.println("2 --- Ver CheckOut");
                System.out.println("3 --- Ver CheckIn e CheckOut");
                opcaoCheck = entrada.nextInt();

                if(opcaoCheck == 1){
                    System.out.println("Clientes que realizaram o CheckIn:");
                       for (Client checkIn: allServer.getCheckIn()){
                           System.out.println("Nome completo: " + checkIn.getFullName() + " | CPF: " + checkIn.getCpf());
                       }
                    System.out.println("------------------------------");
                   System.out.println(newAdm.endService());
                }else if (opcaoCheck == 2){
                    System.out.println("Clientes que realizaram o CheckOut:");
                        for (Client checkOut: allServer.getCheckOut()){
                            System.out.println("Nome completo: " + checkOut.getFullName() + " | CPF: " + checkOut.getCpf());
                        }
                    System.out.println("------------------------------");
                    System.out.println(newAdm.endService());
                } else if(opcaoCheck ==3){
                    System.out.println("Clientes que realizaram o CheckIn e CheckOut:");
                    System.out.println("CheckIn: ");
                        for (Client checkIn: allServer.getCheckIn()){
                            System.out.println("Nome completo: " + checkIn.getFullName() + " | CPF: " + checkIn.getCpf());
                        }
                    System.out.println("------------------------------");
                    System.out.println("CheckOut: ");
                        for (Client checkOut: allServer.getCheckOut()){
                            System.out.println("Nome completo: " + checkOut.getFullName() + " | CPF: " + checkOut.getCpf());
                        }
                    System.out.println("------------------------------");
                    System.out.println(newAdm.endService());
                }

            }
            System.out.println("------------------------------");
            System.out.println("Próximo da fila, por favor...");
            System.out.println("1 --- Possui próximo");
            System.out.println("2 --- Não possui próximo");
            loop = entrada.nextInt();
        } while (loop == 1);
        System.out.println("Obrigado pela sua preferência! Até logo");
        entrada.close();
    }
}
