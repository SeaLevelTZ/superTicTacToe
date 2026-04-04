import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Save{

	public static void writeData(BigBoard b){ //writes current state to file.
		Scanner scan = new Scanner(System.in);
		int coords[] = Main.getCurrentBoard();
		String symbols[] = Main.getSymbol();
		int state = Main.getPlayerState();
		String names[] = Main.getPlayerNames();

		try{
			System.out.print("Enter name of save: ");
			String fileName = scan.nextLine();
			File file = new File("/home/logan/Desktop/Coding/JavaCoding/superTicTacToe/saves",fileName);
			file.createNewFile();//may need to check for existing file.
			FileWriter writer = new FileWriter(file);
			writer.write(""+state+coords[0]+coords[1]+symbols[0]+symbols[1]+"\n");
			writer.write(names[0]+"\n");
			writer.write(names[1]+"\n");
			for(int i = 0;i<3;i++){
				for(int j = 0;j<3;j++){
					int[][] sBoard= b.getBoard(i,j).getSmallArray();
					for(int k = 0;k<3;k++){
						for(int l = 0;l<3;l++){
							writer.write(""+sBoard[k][l]);
						}
					}
					writer.write("\n");
				}
			}
			writer.close();
		}
		catch(IOException e){
			System.out.println("can't create file");
			e.printStackTrace();
		}
	}
	public static void restoreData(BigBoard b) throws FileNotFoundException{ //restores save state
		Scanner scan = new Scanner(System.in);
			System.out.println("Available saves: ");
			File folder = new File("/home/logan/Desktop/Coding/JavaCoding/superTicTacToe/saves");
			File[] list = folder.listFiles();
			for(int i = 0;i<list.length;i++){
				System.out.print(list[i].getName()+" ");
			}
			System.out.println();
			System.out.print("Enter name of save: ");
			String fileName = scan.nextLine();
			File file = new File("/home/logan/Desktop/Coding/JavaCoding/superTicTacToe/saves",fileName);
			Scanner reader = new Scanner(file);
			String[] info = reader.nextLine().split("");
			Main.setPlayerState(Integer.parseInt(info[0]));
			Main.setCurrentBoard(new int[] {Integer.parseInt(info[1]),Integer.parseInt(info[2])});
			Main.setSymbol(new String[] {info[3],info[4]});
			Main.playerName1 = reader.nextLine();
			Main.playerName2 = reader.nextLine();
			for(int i = 0;i<3;i++){
				for(int j = 0;j<3;j++){
					int sBoard[][] = b.getBoard(i,j).getSmallArray();
					String lsBoard[] = reader.nextLine().split("");
					int lBoard[] = new int[9];
					for(int z = 0;z<9;z++){
						lBoard[z] = Integer.parseInt(lsBoard[z]);
					}
					int count = 0;
					for(int k = 0;k<3;k++){
						for(int l = 0;l<3;l++){
							sBoard[k][l] = lBoard[count];
							count++;
						}
					}
				}
			}
			reader.close();
			System.out.println("Game restored!");
	}
}
