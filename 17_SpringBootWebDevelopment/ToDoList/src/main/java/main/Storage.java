package main;

import main.model.Case;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Storage {

    private int currentId = 1;
    private HashMap<Integer, Case> cases = new HashMap<Integer, Case>();

    public List<Case> getAllCases() {
        ArrayList<Case> casesList = new ArrayList<>();
        casesList.addAll(cases.values());
        return casesList;
    }

    public List<String> deleteAllCases() {
        ArrayList<String> casesList = new ArrayList<>();
        casesList.removeAll(cases.values());
        return casesList;
    }

    public Case addCase(Case deal) {
        if (cases.containsKey(currentId)) {
            return null;
        }
        return cases.put(currentId, deal);
    }

    public Case deleteCase(int id) {
        if (cases.containsKey(currentId)){
            return cases.remove(id);
        }
        return null;
    }

    public Case updateCase(int id, Case newCase) {
        if (cases.containsKey(currentId)){
            return cases.replace(id, newCase);
        }
        return null;
    }

    public Case getCase(int caseId) {
        if (cases.containsKey(caseId)) {
            return cases.get(caseId);
        }
        return null;
    }
}
