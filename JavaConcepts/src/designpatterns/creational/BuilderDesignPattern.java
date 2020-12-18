package designpatterns.creational;


public class BuilderDesignPattern {

	public static void main(String[] args) {
		
		ComputerTest cmp = new ComputerTest.ComputerBuilder("520GB", "8GB").setGraphicsCard("Nvidia").build();
		
		System.out.println(cmp.toString());
	}
}


class ComputerTest{
	private String HDD;
	private String RAM;
	
	// OPTIONAL PARAMETERS
	private String graphicCard;
	private String bluetooth;
	public String getHDD() {
		return HDD;
	}
	public String getRAM() {
		return RAM;
	}
	public String getGraphicCard() {
		return graphicCard;
	}
	public String getBluetooth() {
		return bluetooth;
	}
	
	@Override
	public String toString() {
		return "ComputerTest [HDD=" + HDD + ", RAM=" + RAM + ", graphicCard=" + graphicCard + ", bluetooth=" + bluetooth
				+ "]";
	}
	private ComputerTest(ComputerBuilder builder) {
		
		this.HDD = builder.HDD;
		this.RAM = builder.RAM;
		this.graphicCard = builder.graphicCard;
		this.bluetooth = builder.bluetooth;
		
	}
	
	public static class ComputerBuilder{
		private String HDD;
		private String RAM;
		
		// OPTIONAL PARAMETERS
		private String graphicCard;
		private String bluetooth;
		
		public ComputerBuilder(String HDD, String RAM) {
			this.HDD = HDD;
			this.RAM = RAM;
		}
		
		public ComputerBuilder setGraphicsCard(String graphicsCard) {
			this.graphicCard = graphicsCard;
			return this;
		}
		
		public ComputerBuilder serBluetooth(String bluetooth) {
			this.bluetooth = bluetooth;
			return this;
		}
		
		public ComputerTest build() {
			return new ComputerTest(this);
		}
		
	}
	
}