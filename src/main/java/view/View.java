package view;

import javax.swing.*;

public interface View {
    JPanel getPanel();

    void refresh(Integer modelId);
}
