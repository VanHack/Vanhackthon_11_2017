package com.ascent_software;

import com.ascent_software.service.Services;

/**
 * Main class responsible for running the program.
 * 
 * @author renatoramos
 * @date   26/11/2017
 */
public class MainStage {

	public static void main(String[] args) {
		Services serv = new Services();
		serv.run();
	}

}
