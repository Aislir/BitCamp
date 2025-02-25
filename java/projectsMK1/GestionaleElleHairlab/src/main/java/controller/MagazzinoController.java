package controller;

import view.MagazzinoFrame;

public class MagazzinoController {
    MagazzinoFrame magazzinoFrame = new MagazzinoFrame();

    public MagazzinoController() {
        initializeBtn();
    }

    public void initializeBtn(){
        magazzinoFrame.getAggiungi().addActionListener(e -> {
            magazzinoFrame.getVisualizza().setEnabled(true);
            magazzinoFrame.getContentPanel().add(magazzinoFrame.getElementiPanel());
            magazzinoFrame.revalidate();
            magazzinoFrame.repaint();
        });

        magazzinoFrame.getRimuovi().addActionListener(e -> {
            magazzinoFrame.getVisualizza().setEnabled(true);
            magazzinoFrame.getContentPanel().add(magazzinoFrame.getElementiPanel());
            magazzinoFrame.revalidate();
            magazzinoFrame.repaint();
        });

        magazzinoFrame.getVisualizza().addActionListener(e -> {
            magazzinoFrame.getVisualizza().setEnabled(false);
            magazzinoFrame.getContentPanel().remove(magazzinoFrame.getElementiPanel());
            magazzinoFrame.revalidate();
            magazzinoFrame.repaint();
        });
    }

}


