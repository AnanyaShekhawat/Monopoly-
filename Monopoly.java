import java.util.*;
/**
 * Write a description of class Monopoly here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Monopoly
{
    public static void main (String[] args){
        System.out.println();
        System.out.println("Welcome to Monopoly! Mission Style");
        //creating board
        String[][] grid = new String[8][8];
        ArrayList<SquareType> list = new ArrayList<SquareType>();
        ArrayList<Properties> proList = new ArrayList<Properties>();
        ArrayList<Chance> chanceList = new ArrayList<Chance>();
        ArrayList<Railroads> rrList = new ArrayList<Railroads>();
        ArrayList<Utility> uList = new ArrayList<Utility>();
        
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                grid[i][j]=".";
            }
        }
        grid[0][0]= "Go:2:1"; grid[0][1]= "P:Office"; grid[0][2]= "P:C&C Center";
        grid[0][3]= "RR: Horseshoe"; grid[0][4]= "P:L2"; grid[0][5]= "P:Store"; grid[0][6]= "Water Bill";
        grid[0][7]= "Jail"; grid[1][7]= "P:Gym"; grid[2][7]= "P:C120"; grid[3][7]= "RR:Loop";
        grid[4][7]= "P:Stage"; grid[5][7]= "P:Bell Tower"; grid[6][7]= "Chance";
        grid[7][7]= "Free Parking"; grid[7][6]= "P:Pool"; grid[7][5]= "P:Library";
        grid[7][4]= "RR: Parking Lot"; grid[7][3]= "P:P24"; grid[7][2]= "P:E3"; grid[7][1]= "Chance"; 
        grid[7][0]= "Go to Jail"; grid[6][0]= "Luxury Tax"; grid[5][0]= "P:C12";
        grid[4][0]= "P:B7"; grid[3][0]= "RR:Creek"; grid[2][0]= "P:E2A"; grid[1][0]= "P:B2";
        
        list. add(new Go(new int[]{0,0})); 
        proList. add(new Properties(15,40,60,1,"Office",new int[]{0,1}));
        proList. add( new Properties(15,40,60,1,"C&C Center",new int[]{0,2}));
        rrList. add(new Railroads("Horseshoe",new int[]{0,3})); 
        proList. add( new Properties(30,50,100,2,"L2",new int[]{0,4})); 
        proList. add(new Properties(30,50,100,2,"Store",new int[]{0,5})); 
        uList. add( new Utility(new int[]{0,6})); 
        list. add( new Jail(new int[]{0,7})); 
        proList. add( new Properties(40,65,140,3,"Gym",new int[]{1,7})); 
        proList. add( new Properties(45,70,150,3,"C120",new int[]{2,7})); 
        rrList. add( new Railroads("Loop",new int[]{3,7}));
        proList. add( new Properties(60,80,190,4,"Stage",new int[]{4,7})); 
        proList. add( new Properties(65,85,200,4,"Bell Tower",new int[]{5,7})); 
        chanceList. add( new Chance(new int[]{6,7})); 
        list. add( new FreeParking(new int[]{7,7})); 
        proList. add( new Properties(80,100,240,5,"Pool",new int[]{7,6})); 
        proList. add( new Properties(85,110,250,5,"Library",new int[]{7,5})); 
        rrList. add( new Railroads("Parking Lot",new int[]{7,4})); 
        proList. add( new Properties(100,130,290,6,"P24",new int[]{7,3})); 
        proList. add( new Properties(105,135,300,6,"E3",new int[]{7,2})); 
        chanceList. add( new Chance(new int[]{7,1})); 
        list. add( new GoToJail(new int[]{7,0})); 
        list. add( new Tax(new int[]{6,0})); 
        proList. add( new Properties(130,155,350,7,"C12",new int[]{5,0}));
        proList. add( new Properties(135,160,360,7,"B7",new int[]{4,0})); 
        rrList. add( new Railroads("Creek",new int[]{3,0})); 
        proList. add( new Properties(175,190,400,2,"E2A",new int[]{2,0})); 
        proList. add( new Properties(185,200,430,2,"B2",new int[]{1,0}));
        
        Player player1 = new Player(1);
        Player player2 = new Player(2);
        Scanner on = new Scanner(System.in);
        int turn=1;
        
        print(grid);
        while(turn !=0){
            rollAndMove(grid,list,proList,rrList,chanceList,uList,player1, player2,turn);
            print(grid);
            if(turn==1)turn=2; 
            else if(turn==2)turn=1; 
            
            System.out.println("Would you like to end the game?");
            System.out.println("If yes, input \"yes\"  If no, input \"no\"");
            String input=on.nextLine();
            if(input.equals("yes") || turn==0){
                end(player1,player2,proList,rrList,uList);
                turn=0;
            } 
        }
        
    }
    public static void rollAndMove(String[][] grid,ArrayList<SquareType> list,ArrayList<Properties> proList,ArrayList<Railroads> 
    rrList, ArrayList<Chance> chanceList,ArrayList<Utility> uList, Player player1, Player player2,int turn){
        Scanner on = new Scanner(System.in);
        System.out.println("Now it is Player's "+turn+" turn.");
        ArrayList<int[]> points= new ArrayList<int[]>();
        points.add(new int[]{0,0}); points.add(new int[]{0,1}); points.add(new int[]{0,2}); points.add(new int[]{0,3}); points.add(new int[]{0,4}); 
        points.add(new int[]{0,5}); points.add(new int[]{0,6}); points.add(new int[]{0,7}); points.add(new int[]{1,7}); points.add(new int[]{2,7}); 
        points.add(new int[]{3,7}); points.add(new int[]{4,7}); points.add(new int[]{5,7}); points.add(new int[]{6,7}); points.add(new int[]{7,7}); 
        points.add(new int[]{7,6}); points.add(new int[]{7,5}); points.add(new int[]{7,4}); points.add(new int[]{7,3}); points.add(new int[]{7,2});
        points.add(new int[]{7,1}); points.add(new int[]{7,0}); points.add(new int[]{6,0}); points.add(new int[]{5,0}); points.add(new int[]{4,0}); 
        points.add(new int[]{3,0}); points.add(new int[]{2,0}); points.add(new int[]{1,0}); 
        
        Dice die = new Dice();
        int[] moves = die.roll();
        int spaces= moves[0]+moves[1];
        int[] location;
        if(turn==1){
            if(player1.getInJail() ==false){
                for(int i=0; i<points.size();i++){
                    if(points.get(i)[0]==player1.getLoc()[0] && points.get(i)[1]==player1.getLoc()[1]){
                        location=player1.getLoc();
                        grid[location[0]][location[1]]=grid[location[0]][location[1]].substring(0,grid[location[0]][location[1]].length()-2);
                        if(i+spaces>=points.size()){
                            spaces= i+spaces-points.size();
                            System.out.println("You Passed Go! Collect $200.");
                            player1.getPaid(200);
                            location=points.get(spaces);
                            player1.setLoc(points.get(spaces));
                        }
                        else {location=points.get(i+spaces);player1.setLoc(points.get(i+spaces));}
                        grid[location[0]][location[1]]=grid[location[0]][location[1]]+":1";
                        if(grid[location[0]][location[1]].equals("Go")){
                            mortgage(player1,proList,rrList,uList);
                            upgrade(player1,proList);
                            break;
                        }
                        if(grid[location[0]][location[1]].substring(0,2).equals("RR")){
                            
                            Railroads block=rrList.get(0);
                            if(location[0]==0 && location[1]==3){block=rrList.get(0);}
                            else if(location[0]==3 && location[1]==7){block=rrList.get(1);}
                            else if(location[0]==7 && location[1]==4){block=rrList.get(2);}
                            else if(location[0]==3 && location[1]==0){block=rrList.get(3);}
                        
                            System.out.println("Congrats! You have landed on " +block.getName());
                            if(block.getOwner() ==2 && block.getIsMortgage() == false){
                                System.out.println("Player 2 owns this tile. You must pay $"+block.getRent());
                                if(player1.getMoney()>=block.getRent()){
                                    player1.pay(block.getRent());
                                    player2.getPaid(block.getRent());
                                }
                                else{
                                    player1.setMoney(bankrupt(player1,block.getRent()-player1.getMoney(),proList,rrList,uList));
                                    if(player1.getMoney()<0){turn=0;break;}
                                }
                            }
                            else {
                                buyRR(block,player1,rrList); 
                            }  
                            mortgage(player1,proList,rrList,uList);
                            upgrade(player1,proList);
                            break;
                        }
                        else if(grid[location[0]][location[1]].equals("Water Bill")){
                            System.out.println("Congrats! You have landed on Water Bill tile");
                            if(uList.get(0).getOwner() ==2 && uList.get(0).getIsMortgage() == false){
                                System.out.println("Player 2 owns this tile. You must pay $75");
                                if(player1.getMoney()>=50){
                                    player1.pay(50);
                                    player2.getPaid(50);
                                }
                                else{player1.setMoney(bankrupt(player1,50-player1.getMoney(),proList,rrList,uList));if(player1.getMoney()<0){turn=0; break;}}
                            }
                            else {
                                buyUtility(uList.get(0),player1); 
                            }
                            mortgage(player1,proList,rrList,uList);
                            upgrade(player1,proList);
                            break;
                        }
                        else if(grid[location[0]][location[1]].equals("Go To Jail")){
                            System.out.println("Oh,No! You Landed on Go to Jail!");
                            grid[location[0]][location[1]]=grid[location[0]][location[1]].substring(0,grid[location[0]][location[1]].length()-2);
                            location=new int[]{0,7};
                            grid[location[0]][location[1]]=grid[location[0]][location[1]]+":1";
                            player1.setLoc(new int[]{0,7});
                            player1.setInJail(true);
                            break;
                        }
                        else if(grid[location[0]][location[1]].equals("Chance")){
                            String card;
                            System.out.println("Congrats! You have landed on a Chance tile");
                            if(location[0]==7)
                                card = chanceList.get(1).getChance();
                                else
                                card = chanceList.get(0).getChance();
                              //  "Get out of Jail Card", "Go to Jail","Pay $50","Pay $50 to the other player","Pass Go","Collect $20"
                            if(card.equals("Collect $75")){player1.getPaid(75);}
                            if(card.equals("Collect $20")){player1.getPaid(20);}
                            if(card.equals("Pay $50")){
                                if(player1.getMoney()>=50){
                                    player1.pay(50);
                                }
                                else{player1.setMoney(bankrupt(player1,50-player1.getMoney(),proList,rrList,uList));if(player1.getMoney()<0){turn=0; break ;}}
                            }
                            if(card.equals("Pay $50 to the other player")){
                                if(player1.getMoney()>=50){
                                    player1.pay(50);
                                    player2.getPaid(50);
                                }
                                else{player1.setMoney(bankrupt(player1,50-player1.getMoney(),proList,rrList,uList));if(player1.getMoney()<0){turn=0; break ;}}
                            }
                            if(card.equals("Go to Jail")){
                                System.out.println("Oh,No! You Landed on Go to Jail!");
                                grid[location[0]][location[1]]=grid[location[0]][location[1]].substring(0,grid[location[0]][location[1]].length()-2);
                                location=new int[]{0,7};
                                grid[location[0]][location[1]]=grid[location[0]][location[1]]+":1";
                                player1.setLoc(new int[]{0,7});
                                player1.setInJail(true);
                            }
                            if(card.equals("Get out of Jail Card")){player1.addChance(card);}
                                mortgage(player1,proList,rrList,uList);
                                upgrade(player1,proList);
                                break;
                            }
                            else if(grid[location[0]][location[1]].equals("Luxury Tax")){
                                Tax block = new Tax(location);
                                System.out.println("Oh,No! You have landed on " +block.getName()+". You have to pay $75");
                                if(player1.getMoney()>=75){
                                    player1.pay(75);
                                }
                                else{player1.setMoney(bankrupt(player1,75-player1.getMoney(),proList,rrList,uList));
                                    if(player1.getMoney()<0){turn=0; break ;}
                            }
                            mortgage(player1,proList,rrList,uList);
                            upgrade(player1,proList);
                            break;
                            }
                            else if(grid[location[0]][location[1]].equals("Free Parking")){
                                System.out.println("You Landed on Free Parking! Collect $75.");
                                player1.getPaid(75);
                                mortgage(player1,proList,rrList,uList);
                                upgrade(player1,proList);
                                break;
                            }
                            else if(grid[location[0]][location[1]].substring(0,1).equals("P")){
                                Properties block=proList.get(0);  
                                for(int j=0; j<proList.size();j++){
                                    if(location[0]==proList.get(j).getLoc()[0] && location[1]==proList.get(j).getLoc()[1]){
                                        block=proList.get(j); 
                                    }
                                }
                        
                                System.out.println("You have landed on " +block.getName()); 
                                if(block.getOwner() == 2 && block.getIsMortgage() == false){
                                    System.out.println("Player 2 owns this tile. You must pay $"+block.getRent());
                                    if(player1.getMoney()>=block.getRent()){
                                        player1.pay(block.getRent());
                                        player2.getPaid(block.getRent());
                                    }
                                    else{player1.setMoney(bankrupt(player1,block.getRent()-player1.getMoney(),proList,rrList,uList));if(player1.getMoney()<0){turn=0; break ;}}
                                }
                                else {buyProp(block,player1,proList); } 
                                mortgage(player1,proList,rrList,uList);
                                upgrade(player1,proList);
                                break;
                            }
                        }
                        break;
                    }
                }
                else{
                    for(int i=0; i<player1.getChance().size();i++){
                        if(player1.getChance().get(i).equals("Get out of Jail Card")){
                            player1.setInJail(false);
                        }
                    }
                    if(moves[0]==moves[1]){player1.setInJail(false);}
                }
            }
        else if(turn==2){
            if(player2.getInJail() ==false){
                for(int i=0; i<points.size();i++){
                    if(points.get(i)[0]==player2.getLoc()[0] && points.get(i)[1]==player2.getLoc()[1]){
                        location=player2.getLoc();
                        grid[location[0]][location[1]]=grid[location[0]][location[1]].substring(0,grid[location[0]][location[1]].length()-2);
                        if(i+spaces>=points.size()){
                            spaces= i+spaces-points.size();
                            System.out.println("You Passed Go! Collect $200.");
                            player2.getPaid(200);
                            location=points.get(spaces);
                            player2.setLoc(points.get(spaces));
                        }
                        else {location=points.get(i+spaces); player2.setLoc(points.get(i+spaces));}
                        grid[location[0]][location[1]]=grid[location[0]][location[1]]+":2";
                        if(grid[location[0]][location[1]].equals("Go")){
                            mortgage(player2,proList,rrList,uList);
                            upgrade(player2,proList);
                            break;
                        }
                    
                        if(grid[location[0]][location[1]].substring(0,2).equals("RR")){
                            Railroads block=rrList.get(0);
                            if(location[0]==0 && location[1]==3){block=rrList.get(0);}
                            else if(location[0]==3 && location[1]==7){block=rrList.get(1);}
                            else if(location[0]==7 && location[1]==4){block=rrList.get(2);}
                            else if(location[0]==3 && location[1]==0){block=rrList.get(3);}
                        
                            System.out.println("Congrats! You have landed on " +block.getName());
                            if(block.getOwner() ==1 && block.getIsMortgage() == false){
                                System.out.println("Player 1 owns this tile. You must pay $"+block.getRent());
                                if(player1.getMoney()>=block.getRent()){
                                    player2.pay(block.getRent());
                                    player1.getPaid(block.getRent());
                                }
                                else{player2.setMoney(bankrupt(player2,block.getRent()-player1.getMoney(),proList,rrList,uList));if(player2.getMoney()<0){turn=0; break ;}}
                            }
                            else {
                                buyRR(block,player2,rrList); 
                            }  
                            mortgage(player2,proList,rrList,uList);
                            upgrade(player2,proList);
                            break;
                        }
                        else if(grid[location[0]][location[1]].equals("Water Bill")){
                            System.out.println("Congrats! You have landed on Water Bill tile");
                            if(uList.get(0).getOwner() ==1 && uList.get(0).getIsMortgage() == false){
                                System.out.println("Player 1 owns this tile. You must pay $75");
                                if(player1.getMoney()>=50){
                                    player2.pay(50);
                                    player1.getPaid(50);
                                }
                                else{player2.setMoney(bankrupt(player2,50-player1.getMoney(),proList,rrList,uList));if(player2.getMoney()<0){turn=0; break ;}}
                            }
                            else {
                                buyUtility(uList.get(0),player2); 
                            }
                            mortgage(player2,proList,rrList,uList);
                            upgrade(player2,proList);
                            break;
                        }
                        else if(grid[location[0]][location[1]].equals("Go To Jail")){
                            System.out.println("Oh,No! You Landed on Go to Jail!");
                                grid[location[0]][location[1]]=grid[location[0]][location[1]].substring(0,grid[location[0]][location[1]].length()-2);
                                location=new int[]{0,7};
                                grid[location[0]][location[1]]=grid[location[0]][location[1]]+":2";
                                player2.setLoc(new int[]{0,7});
                                player2.setInJail(true);
                        }
                        else if(grid[location[0]][location[1]].equals("Chance")){
                            String card;
                            System.out.println("Congrats! You have landed on a Chance tile");
                            if(location[0]==7)
                                card = chanceList.get(1).getChance();
                                else
                                card = chanceList.get(0).getChance();
                                System.out.println("You're chance card is "+card);
                            if(card.equals("Collect $150")){player2.getPaid(50);}
                            if(card.equals("Collect $20")){player2.getPaid(20);}
                            if(card.equals("Pay $50")){
                                if(player1.getMoney()>=50){
                                    player2.pay(50);
                                }
                                else{player2.setMoney(bankrupt(player2,50-player1.getMoney(),proList,rrList,uList));if(player2.getMoney()<0){turn=0; break ;}}}
                            if(card.equals("Pay $50 to the other player")){
                                if(player1.getMoney()>=50){
                                    player2.pay(50);
                                    player1.getPaid(50);
                                }
                                else{player2.setMoney(bankrupt(player2,50-player1.getMoney(),proList,rrList,uList));if(player2.getMoney()<0){turn=0; break ;}}
                            }
                            if(card.equals("Go to Jail")){
                                System.out.println("Oh,No! You Landed on Go to Jail!");
                                grid[location[0]][location[1]]=grid[location[0]][location[1]].substring(0,grid[location[0]][location[1]].length()-2);
                                location=new int[]{0,7};
                                grid[location[0]][location[1]]=grid[location[0]][location[1]]+":2";
                                player2.setLoc(new int[]{0,7});
                                player2.setInJail(true);
                            }
                            if(card.equals("Get out of Jail Card")){player2.addChance(card);}
                            mortgage(player2,proList,rrList,uList);
                            upgrade(player2,proList);
                            break;
                            }
                            else if(grid[location[0]][location[1]].equals("Luxury Tax")){
                                Tax block = new Tax(location);
                                System.out.println("Oh,No! You have landed on " +block.getName()+"You have to pay $75");
                                if(player1.getMoney()>=75){
                                    player2.pay(75);
                                }
                                else{player2.setMoney(bankrupt(player2,75-player1.getMoney(),proList,rrList,uList));if(player2.getMoney()<0){turn=0; break;}}
                                mortgage(player2,proList,rrList,uList);
                                upgrade(player2,proList);
                                break;
                            }
                            else if(grid[location[0]][location[1]].equals("Free Parking")){
                                System.out.println("You Landed on Free Parking! Collect $75.");
                                player2.getPaid(75);
                                mortgage(player2,proList,rrList,uList);
                                upgrade(player2,proList);
                                break;
                            }
                            else if(grid[location[0]][location[1]].substring(0,1).equals("P")){
                                Properties block=proList.get(0);  
                                for(int j=0; j<proList.size();j++){
                                    if(location[0]==proList.get(j).getLoc()[0] && location[1]==proList.get(j).getLoc()[1]){
                                        block=proList.get(j); 
                                    }
                                }
                        
                                System.out.println("You have landed on " +block.getName()); 
                                if( block.getOwner() == 1 && block.getIsMortgage() == false){
                                    System.out.println("Player 1 owns this tile. You must pay $"+block.getRent());
                                    if(player1.getMoney()>=block.getRent()){
                                        player2.pay(block.getRent());
                                        player1.getPaid(block.getRent()); 
                                    }
                                    else{player2.setMoney(bankrupt(player2,block.getRent()-player1.getMoney(),proList,rrList,uList));if(player2.getMoney()<0){turn=0; break ;}}
                                    }
                                else {buyProp(block,player2,proList); 
                                } 
                                mortgage(player2,proList,rrList,uList);
                                upgrade(player2,proList);
                                break;
                            }
                             break;
                        }
                        
                    }
                }
                else{
                    for(int i=0; i<player1.getChance().size();i++){
                        if(player2.getChance().get(i).equals("Get out of Jail Card")){
                            player2.setInJail(false);
                        }
                    }
                    if(moves[0]==moves[1]){player2.setInJail(false);}
                }
            }
        }
    
    public static void buyProp(Properties block,Player onePlayer,ArrayList<Properties> proList){
        Scanner on = new Scanner(System.in);
        System.out.println("Would you like to buy "+block.getName());
        System.out.println("If yes, input \"yes\"");
        System.out.println("If no, input \"no\"");
        System.out.println("If you want to see the "+block.getTileType()+"'s information, input \"info\" ");
        System.out.println("If you want to see your information, input \"player\" ");
        String input =on.nextLine();
        if(input.equals("info")){
            System.out.println(block.toString());
            System.out.println("Would you like to buy "+block.getName());
            System.out.println("If yes, input \"yes\"");
            System.out.println("If no, input \"no\"");
            System.out.println("If you want to see your information, input \"player\" ");
            input =on.nextLine();
            if(input.equals("player")){
                System.out.println(onePlayer.toString());
                System.out.println("Would you like to buy "+block.getName());
                System.out.println("If yes, input \"yes\"");
                System.out.println("If no, input \"no\"");
                input =on.nextLine();
            }
            
        }
        else if(input.equals("player")){
            System.out.println(onePlayer.toString());
            System.out.println("Would you like to buy "+block.getName());
            System.out.println("If yes, input \"yes\"");
            System.out.println("If no, input \"no\"");
            System.out.println("If you want to see the "+block.getTileType()+"'s information, input \"info\" ");
            input =on.nextLine();
            if(input.equals("info")){
                System.out.println(block.toString());
                System.out.println("Would you like to buy "+block.getName());
                System.out.println("If yes, input \"yes\"");
                System.out.println("If no, input \"no\"");
                input =on.nextLine();
            }
        }
        if(input.equals("yes") && block.getOwner() == onePlayer.player()){
            System.out.print("This property is already owned by you");
        }
        else if(input.equals("yes") && onePlayer.getMoney()<block.getPrice()){
             System.out.print("I am sorry this property is not in your price range");
        }
        else if(input.equals("yes")&& onePlayer.getMoney()>=block.getPrice() && block.getOwner() == 0){
            System.out.println("Congrats! You have bought this tile");
            onePlayer.pay(block.getPrice());
            block.setOwner(onePlayer.player());
            for(int j=0; j<proList.size();j=j+2){
                 if(block.getGroup()==proList.get(j).getGroup() && block.getGroup()==proList.get(j+1).getGroup() && proList.get(j).getOwner()
                 == onePlayer.player() && proList.get(j+1).getOwner()==onePlayer.player()){
                      proList.get(j).setallBlockBought(); proList.get(j+1).setallBlockBought(); 
                 }
            }
            onePlayer.addProperty(block);
            System.out.println(onePlayer.toString());
        }
        else{System.out.println("You have not bought the tile");}
    }
    
        public static void buyUtility(Utility block,Player onePlayer){
        Scanner on = new Scanner(System.in);
        System.out.println("Would you like to buy "+block.getName());
        System.out.println("If yes, input \"yes\"");
        System.out.println("If no, input \"no\"");
        System.out.println("If you want to see the "+block.getTileType()+"'s information, input \"info\" ");
        System.out.println("If you want to see your information, input \"player\" ");
        String input =on.nextLine();
        if(input.equals("info")){
            System.out.println(block.toString());
            System.out.println("Would you like to buy "+block.getName());
            System.out.println("If yes, input \"yes\"");
            System.out.println("If no, input \"no\"");
            System.out.println("If you want to see your information, input \"player\" ");
            input =on.nextLine();
            if(input.equals("player")){
                System.out.println(onePlayer.toString());
                System.out.println("Would you like to buy "+block.getName());
                System.out.println("If yes, input \"yes\"");
                System.out.println("If no, input \"no\"");
                input =on.nextLine();
            }
            
        }
        else if(input.equals("player")){
            System.out.println(onePlayer.toString());
            System.out.println("Would you like to buy "+block.getName());
            System.out.println("If yes, input \"yes\"");
            System.out.println("If no, input \"no\"");
            System.out.println("If you want to see the "+block.getTileType()+"'s information, input \"info\" ");
            input =on.nextLine();
            if(input.equals("info")){
                System.out.println(block.toString());
                System.out.println("Would you like to buy "+block.getName());
                System.out.println("If yes, input \"yes\"");
                System.out.println("If no, input \"no\"");
                input =on.nextLine();
            }
        }
        if(input.equals("yes") && block.getOwner() == onePlayer.player()){
            System.out.println("This Water Bill is already owned by you");
        }
        else if(input.equals("yes") && onePlayer.getMoney()<block.getPrice()){
             System.out.println("I am sorry this tile is not in your price range");
        }
        else if(input.equals("yes")&& onePlayer.getMoney()>=block.getPrice() && block.getOwner() == 0){
            System.out.println("Congrats! You have bought this tile");
            onePlayer.pay(block.getPrice());
            onePlayer.addProperty(block);
            block.setOwner(onePlayer.player()); 
            System.out.println(onePlayer.toString());
        }
        else{System.out.println("You have not bought the tile");}
    }
    
       public static void buyRR(Railroads block,Player onePlayer,ArrayList<Railroads> rrList){
        Scanner on = new Scanner(System.in);
        System.out.println("Would you like to buy "+block.getName());
        System.out.println("If yes, input \"yes\"");
        System.out.println("If no, input \"no\"");
        System.out.println("If you want to see the "+block.getTileType()+"'s information, input \"info\" ");
        System.out.println("If you want to see your information, input \"player\" ");
        String input =on.nextLine();
        if(input.equals("info")){
            System.out.println(block.toString());
            System.out.println("Would you like to buy "+block.getName());
            System.out.println("If yes, input \"yes\"");
            System.out.println("If no, input \"no\"");
            System.out.println("If you want to see your information, input \"player\" ");
            input =on.nextLine();
            if(input.equals("player")){
                System.out.println(onePlayer.toString());
                System.out.println("Would you like to buy "+block.getName());
                System.out.println("If yes, input \"yes\"");
                System.out.println("If no, input \"no\"");
                input =on.nextLine();
            }
            
        }
        else if(input.equals("player")){
            System.out.println(onePlayer.toString());
            System.out.println("Would you like to buy "+block.getName());
            System.out.println("If yes, input \"yes\"");
            System.out.println("If no, input \"no\"");
            System.out.println("If you want to see the "+block.getTileType()+"'s information, input \"info\" ");
            input =on.nextLine();
            if(input.equals("info")){
                System.out.println(block.toString());
                System.out.println("Would you like to buy "+block.getName());
                System.out.println("If yes, input \"yes\"");
                System.out.println("If no, input \"no\"");
                input =on.nextLine();
            }
        }
        if(input.equals("yes") && block.getOwner() == onePlayer.player()){
            System.out.println("This railroad is already owned by you");
        }
        else if(input.equals("yes") && onePlayer.getMoney()<block.getPrice()){
             System.out.println("I am sorry this railroad is not in your price range");
        }
        else if(input.equals("yes")&& onePlayer.getMoney()>=block.getPrice() && block.getOwner() == 0){
            System.out.println("Congrats! You have bought this tile");
            onePlayer.pay(block.getPrice());
            onePlayer.addProperty(block);
            block.setOwner(onePlayer.player());
            int x=0;
            for(int j=0; j<rrList.size();j++){
                 if(rrList.get(j).getOwner()==onePlayer.player()){
                      x++;
                 }
            }
            if(rrList.get(0).getOwner()==onePlayer.player()){
                     rrList.get(0).setRent(x);
                 }
            if(rrList.get(1).getOwner()==onePlayer.player()){
                     rrList.get(0).setRent(x);
                 }
            if(rrList.get(2).getOwner()==onePlayer.player()){
                     rrList.get(0).setRent(x);
                 }
            if(rrList.get(3).getOwner()==onePlayer.player()){
                      rrList.get(0).setRent(x);
                 }
            System.out.println(onePlayer.toString());
        }
        else{System.out.println("You have not bought the tile");}
    }
    public static void mortgage(Player onePlayer,ArrayList<Properties> proList,ArrayList<Railroads> rrList,ArrayList<Utility> uList){
        Scanner on = new Scanner(System.in);
        System.out.println("Would you like to mortgage any properties,utilities,railroads?");
        System.out.println("If yes, input \"yes\"");
        System.out.println("If no, input \"no\"");
        System.out.println("If you want to see your information, input \"player\" ");
        String input = on.nextLine();
        if(input.equals("player")){
            System.out.println(onePlayer.toString());
            System.out.println("Would you like to mortgage any properties,utilities,railroads?");
            System.out.println("If yes, input \"yes\"");
            System.out.println("If no, input \"no\"");
            input = on.nextLine();
        }
        if(input.equals("yes")){
            System.out.println("What you like to mortgage?");
            System.out.println("Input either: property,utility,or railroad. If your tile is mortgaged, it will state so");
            String in = on.nextLine();
            if(in.equals("utility") && uList.get(0).getOwner()==onePlayer.player()&& uList.get(0).getIsMortgage()==false){
                uList.get(0).setIsMortgage(); 
                onePlayer.getPaid(uList.get(0).getMortgage());
                System.out.println(uList.get(0).toString());
                System.out.println("Your utility is now mortgaged.");
            }
            else if(in.equals("property")){
                System.out.println("Input the name of the property: anything after the colons(ie. \"C120\").");
                String prop = on.nextLine();
                for(int j=0; j<proList.size();j++){
                    if(proList.get(j).getName().equals(prop) && proList.get(j).getOwner()==onePlayer.player() && proList.get(j).getIsMortgage()==false
                    && proList.get(j).isUpgraded()==false){
                        proList.get(j).setIsMortgage(); 
                        onePlayer.getPaid(proList.get(j).getMortgage());
                        System.out.println(proList.get(j).toString());
                        System.out.println("Your "+proList.get(j).getName()+" tile is now mortgaged.");
                    }
                }
            }
            else if(in.equals("railroad")){
                System.out.println("Input the name of the property: anything after the colons(ie. \"Creek\").");
                String rr = on.nextLine();
                for(int j=0; j<rrList.size();j++){
                    if(rrList.get(j).getName().equals(rr) && rrList.get(j).getOwner()==onePlayer.player() && rrList.get(j).getIsMortgage()==false){
                        rrList.get(j).setIsMortgage(); 
                        onePlayer.getPaid(rrList.get(j).getMortgage());
                        System.out.println(rrList.get(j).toString());
                        System.out.println("Your "+rrList.get(j).getName()+" tile is now mortgaged.");
                    }
                }
            }
            System.out.println("Would you like to mortgage any other properties,utilities,railroads?");
            System.out.println("If yes, input \"yes\"");
            System.out.println("If no, input \"no\"");
            in = on.nextLine();
            if(in.equals("yes")){mortgage(onePlayer,proList,rrList,uList);}
        }
    }
    public static void upgrade(Player onePlayer,ArrayList<Properties> proList){
        Scanner on = new Scanner(System.in);
        System.out.println("Would you like to upgrade any properties? If your tile is upgraded, it will state so");
        System.out.println("If yes, input \"yes\"");
        System.out.println("If no, input \"no\"");
        System.out.println("If you want to see your information, input \"player\" ");
        String input = on.nextLine();
        if(input.equals("player")){
            System.out.println(onePlayer.toString());
            System.out.println("Would you like to upgrade any properties?");
            System.out.println("If yes, input \"yes\"");
            System.out.println("If no, input \"no\"");
            input = on.nextLine();
        }
        if(input.equals("yes")){
            System.out.println("Input the name of the property: anything after the colons(ie. \"C120\")");
            String prop = on.nextLine();
            for(int j=0; j<proList.size();j++){
               if(proList.get(j).getName().equals(prop) && proList.get(j).getOwner()==onePlayer.player() && proList.get(j).getIsMortgage()==false 
               && proList.get(j).getallBlockBought()==true && j!=0 && j!=proList.size()&&((proList.get(j-1).getGroup()==proList.get(j).getGroup() &&
               proList.get(j-1).getHouses()<=proList.get(j).getHouses()) || (proList.get(j+1).getGroup()==proList.get(j).getGroup() &&
               proList.get(j+1).getHouses()<=proList.get(j).getHouses()))){
                      proList.get(j).upgradeProp(); 
                      System.out.println(proList.get(j).toString());
                      System.out.println("Your "+proList.get(j).getName()+" tile is now upgraded and the rent is now "+proList.get(j).getRent()+".");
               }
               else if(proList.get(j).getName().equals(prop) && proList.get(j).getOwner()==onePlayer.player() && proList.get(j).getIsMortgage()==false 
               && proList.get(j).getallBlockBought()==true && j==0 && (proList.get(j+1).getGroup()==proList.get(j).getGroup() &&
               proList.get(j+1).getHouses()<=proList.get(j).getHouses())){
                      proList.get(j).upgradeProp(); 
                      System.out.println(proList.get(j).toString());
                      System.out.println("Your "+proList.get(j).getName()+" tile is now upgraded and the rent is now "+proList.get(j).getRent()+".");
               }
               else if(proList.get(j).getName().equals(prop) && proList.get(j).getOwner()==onePlayer.player() && proList.get(j).getIsMortgage()==false 
               && proList.get(j).getallBlockBought()==true && j==proList.size() &&proList.get(j-1).getGroup()==proList.get(j).getGroup() &&
               proList.get(j-1).getHouses()<=proList.get(j).getHouses()){
                      proList.get(j).upgradeProp(); 
                      System.out.println(proList.get(j).toString());
                      System.out.println("Your "+proList.get(j).getName()+" tile is now upgraded and the rent is now "+proList.get(j).getRent()+".");
               }
               else if(proList.get(j).getName().equals(prop) && proList.get(j).getOwner()==onePlayer.player() && proList.get(j).getIsMortgage()==false 
               && proList.get(j).getallBlockBought()==true && j!=0 &&(proList.get(j-1).getGroup()==proList.get(j).getGroup() &&
               proList.get(j-1).getHouses()>proList.get(j).getHouses())){
                      System.out.print("The number of houses is uneven. A house will be added to "+proList.get(j-1).getName()+" instead.");
                      proList.get(j-1).upgradeProp(); 
                      System.out.println(proList.get(j-1).toString());
                      System.out.println("Your "+proList.get(j-1).getName()+" tile is now upgraded and the rent is now "+proList.get(j-1).getRent()+".");
               }
               if(proList.get(j).getName().equals(prop) && proList.get(j).getOwner()==onePlayer.player() && proList.get(j).getIsMortgage()==false 
               && proList.get(j).getallBlockBought()==true && j!=proList.size() &&proList.get(j+1).getGroup()==proList.get(j).getGroup() &&
               proList.get(j+1).getHouses()<=proList.get(j).getHouses()){
                      System.out.print("The number of houses is uneven. A house will be added to "+proList.get(j+1).getName()+" instead.");
                      proList.get(j+1).upgradeProp(); 
                      System.out.println(proList.get(j+1).toString());
                      System.out.println("Your "+proList.get(j+1).getName()+" tile is now upgraded and the rent is now "+proList.get(j+1).getRent()+".");
               }
               if(proList.get(j).getName().equals(prop) && proList.get(j).getOwner()==onePlayer.player() && proList.get(j).getIsMortgage()==false 
               && proList.get(j).getallBlockBought()==true && j==0 && proList.get(j+1).getGroup()==proList.get(j).getGroup() &&
               proList.get(j+1).getHouses()<=proList.get(j).getHouses()){
                        System.out.print("The number of houses is uneven. A house will be added to "+proList.get(j+1).getName()+" instead.");
                      proList.get(j+1).upgradeProp(); 
                      System.out.println(proList.get(j+1).toString());
                      System.out.println("Your "+proList.get(j+1).getName()+" tile is now upgraded and the rent is now "+proList.get(j+1).getRent()+".");
               }
               if(proList.get(j).getName().equals(prop) && proList.get(j).getOwner()==onePlayer.player() && proList.get(j).getIsMortgage()==false 
               && proList.get(j).getallBlockBought()==true && j==proList.size()&& proList.get(j-1).getGroup()==proList.get(j).getGroup() &&
               proList.get(j-1).getHouses()<=proList.get(j).getHouses()){
                      System.out.print("The number of houses is uneven. A house will be added to "+proList.get(j-1).getName()+" instead.");
                      proList.get(j-1).upgradeProp(); 
                      System.out.println(proList.get(j-1).toString());
                      System.out.println("Your "+proList.get(j-1).getName()+" tile is now upgraded and the rent is now "+proList.get(j-1).getRent()+".");
               }
               if(proList.get(j).getName().equals(prop) && proList.get(j).getOwner()!=onePlayer.player()){
                       System.out.println("You are not the owner of this property");
                } 
                if(proList.get(j).getName().equals(prop) && proList.get(j).getOwner()==onePlayer.player() && proList.get(j).getIsMortgage()!=false 
               && proList.get(j).getallBlockBought()==true){
                       System.out.println("The property is under mortgage.");
                }
               if(proList.get(j).getName().equals(prop) && proList.get(j).getOwner()==onePlayer.player() && proList.get(j).getIsMortgage()==false 
                && proList.get(j).getallBlockBought()!=true){
                       System.out.println("You have not bought the whole block.");
                }
                }
                System.out.println("Would you like to upgrade any other properties?");
                System.out.println("If yes, input \"yes\"");
                System.out.println("If no, input \"no\"");
                String in = on.nextLine();
                if(in.equals("yes")){upgrade(onePlayer,proList);}
            }
        
        
    }
    public static int bankrupt(Player onePlayer, int moneyOwned,ArrayList<Properties> proList,ArrayList<Railroads> rrList,ArrayList<Utility> uList){
        while(moneyOwned>0){
            if(uList.get(0).getOwner()==onePlayer.player()&& uList.get(0).getIsMortgage()==false){
                uList.get(0).setIsMortgage(); 
                onePlayer.getPaid(uList.get(0).getMortgage());
                System.out.println("Your utility is now mortgaged.");
                moneyOwned=-uList.get(0).getMortgage();
                if(moneyOwned<=0){break;}
            }
            for(int j=0; j<proList.size();j++){
                if(proList.get(j).getOwner()==onePlayer.player() && proList.get(j).getIsMortgage()==false && proList.get(j).isUpgraded()==false){
                        proList.get(j).setIsMortgage(); 
                        onePlayer.getPaid(proList.get(j).getMortgage());
                        System.out.println("Your "+proList.get(j).getName()+" tile is now mortgaged.");
                        moneyOwned=-proList.get(j).getMortgage();
                    }
                if(moneyOwned<=0){break;}
                }  
            for(int j=0; j<rrList.size();j++){
                  if( rrList.get(j).getOwner()==onePlayer.player() && rrList.get(j).getIsMortgage()==false){
                        rrList.get(j).setIsMortgage(); 
                        onePlayer.getPaid(rrList.get(j).getMortgage());
                        System.out.println("Your "+rrList.get(j).getName()+" tile is now mortgaged.");
                    } 
                  if(moneyOwned<=0){break;}  
            }
            if(moneyOwned>0){System.out.println("Oh,no. You are bankrupt! You lose!");break;}
        }
        return onePlayer.getMoney();
    }
    public static void end(Player player1,Player player2,ArrayList<Properties> proList,ArrayList<Railroads> rrList,ArrayList<Utility> uList){
        int moneyOne=0;
        int moneyTwo=0;
        
        if(uList.get(0).getOwner()==player1.player()&& uList.get(0).getIsMortgage()==false){
                moneyOne=moneyOne+uList.get(0).getPrice();
            }
        for(int j=0; j<proList.size();j++){
            if(proList.get(j).getOwner()==player1.player() && proList.get(j).getIsMortgage()==false && proList.get(j).isUpgraded()!=true){
                moneyOne=moneyOne+proList.get(j).getPrice();
                    }
            if(proList.get(j).getOwner()==player1.player() && proList.get(j).getIsMortgage()==false && proList.get(j).isUpgraded()==true){
                moneyOne=moneyOne+proList.get(j).getPrice()+proList.get(j).getRent();
                    }
                }  
        for(int j=0; j<rrList.size();j++){
            if( rrList.get(j).getOwner()==player1.player() && rrList.get(j).getIsMortgage()==false){
                moneyOne=moneyOne+rrList.get(j).getPrice();
                    } 
            }
            moneyOne=moneyOne+player1.getMoney();
            
         if(uList.get(0).getOwner()==player2.player()&& uList.get(0).getIsMortgage()==false){
                moneyTwo=moneyTwo+uList.get(0).getPrice();
            }
        for(int j=0; j<proList.size();j++){
            if(proList.get(j).getOwner()==player2.player() && proList.get(j).getIsMortgage()==false && proList.get(j).isUpgraded()!=true){
                moneyTwo=moneyTwo+proList.get(j).getPrice();
                    }
            if(proList.get(j).getOwner()==player2.player() && proList.get(j).getIsMortgage()==false && proList.get(j).isUpgraded()==true){
                moneyTwo=moneyTwo+proList.get(j).getPrice()+proList.get(j).getRent();
                    }
                }  
        for(int j=0; j<rrList.size();j++){
            if( rrList.get(j).getOwner()==player2.player() && rrList.get(j).getIsMortgage()==false){
                moneyTwo=moneyTwo+rrList.get(j).getPrice();
                    } 
            }
          moneyTwo=moneyTwo+player2.getMoney();
         if(moneyTwo>moneyOne){
            System.out.println("Congrats to Player 2 for Winning!!");
            }
         else{System.out.println("Congrats to Player 1 for Winning!!");}
    
    }
    
    public static void print(String[][] grid){
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(grid[i][j].equals(".") && i !=3)
                    System.out.print("          ");
                else if(grid[i][j].equals(".") && i ==3){
                    System.out.print("        ");
                }
                else
                    System.out.print(grid[i][j]+"|");
            }
            System.out.println();
        }
        System.out.println();
    }
}
