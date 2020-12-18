package family.main;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

import family.controller.FamilyMainController;
import family.model.FamilyManagerInput;
import family.model.FamilyManagerResponse;
import family.model.Gender;
import family.service.FamilyControllerImpl;

public class Geektrust {
	
	public static void handleFamily(String line) {
		FamilyMainController familyController = new FamilyControllerImpl();
		String[] input = line.split(" ");
		if(input[0].equalsIgnoreCase(FamilyManagerInput.ADD_CHILD.name())) {
			if(input.length >= 4)
				System.out.println(familyController.addChild(input[1], input[2], input[3]== "Male" ? Gender.MALE:Gender.FEMALE).getResult());
			else
				System.out.println("Invalid Input");
		}	
		else if(input[0].equalsIgnoreCase(FamilyManagerInput.GET_RELATIONSHIP.name())) {
			FamilyManagerResponse response = null;
			if(input.length >= 3)
				response = familyController.getRelationship(input[1], input[2]);
			if(response.getRelatives()!= null && response.getRelatives().size()>0) {
				for(String name: response.getRelatives()) {
					System.out.print(name);
					System.out.print(" ");
				}
			}else {
				System.out.println(response.getResult());
			}
			System.out.println();
		}else
			System.out.println("Invalid Input");
	
	}

	public static void main(String[] args) {
		
		String filePath = null;
		if(args.length>0)
			filePath = args[0];
		else {
			System.out.println("File Path doesn't exist.....");
		}
		List<String> lines = Collections.emptyList();
		try {
			lines = Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8);
		}

		catch (IOException e) {
			System.out.println("Couldn't find file");
			e.printStackTrace();
		}
		for(String line: lines) {
			handleFamily(line);
		}
		
	}

}
