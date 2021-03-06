package com.ardublock.translator.block.freesensors;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class FsDigitalInput extends TranslatorBlock {

	public FsDigitalInput(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label) {
		super(blockId, translator, codePrefix, codeSuffix, label);
	}

	@Override
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException {
		String auxS;
		TranslatorBlock shield, port; 
		shield = this.getRequiredTranslatorBlockAtSocket(0);
		port = this.getRequiredTranslatorBlockAtSocket(1);
		auxS = shield.toCode()+".pinMode("+"DIO"+port.toCode()+", INPUT);\n";
		translator.addSetupCommand(auxS);
		auxS = shield.toCode()+".digitalRead("+"DIO"+port.toCode()+")";
		return auxS;
	}

}
