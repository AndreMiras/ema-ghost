package com.standard.dev.ui.sequences;

import com.standard.architecture.ui.navigation.JPanelS;
import com.standard.architecture.ui.service.Service;
import com.standard.dev.ui.services.Chargement.ChrEspace;

public interface Sequence {
	public void lanceSequence(Service service, ChrEspace espaceChargement);
}
