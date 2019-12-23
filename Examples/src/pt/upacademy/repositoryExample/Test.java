package pt.upacademy.repositoryExample;
import pt.upacademy.repositoryExample.entities.Automovel;
import pt.upacademy.repositoryExample.entities.Mota;
import pt.upacademy.repositoryExample.repositories.AutomovelRepository;
import pt.upacademy.repositoryExample.repositories.MotaRepository;

public class Test {
	
	private static MotaRepository repositorioDeMotas= new MotaRepository();
	private static AutomovelRepository repositorioDeAutomoveis= new AutomovelRepository();
	
	public static void main(String[] args) {
		run();
	}
	
	public static void run() {
		
		Mota mota1 = new Mota(2,0,"Piaggio",5,250);
		
		repositorioDeMotas.save(mota1);
	
		System.out.println(repositorioDeMotas.findById((long)0).getMarca());
		
		Automovel auto = new Automovel(4, 2,"Ferrari", "RadioTech", 10);
		
		repositorioDeAutomoveis.save(auto);
		
		String marca= repositorioDeAutomoveis.findById((long)0).getMarca();
		
		System.out.println(marca);
		
		Object[] list= repositorioDeAutomoveis.getAll().toArray();
		
		for(int i=0;i<list.length;i++)
			System.out.println(((Automovel)list[i]).getMarca());
	}

}
