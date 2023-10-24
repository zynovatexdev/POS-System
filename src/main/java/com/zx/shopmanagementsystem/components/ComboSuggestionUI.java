package com.zx.shopmanagementsystem.components;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.border.EmptyBorder;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import com.zx.shopmanagementsystem.components.ScrollBarCustom;

public class ComboSuggestionUI extends BasicComboBoxUI {

    private Color borderColor = new Color(255, 255, 255);
    private Color focusColor = new Color(128, 189, 255);
    private Color backgroundColor = new Color(0, 0, 0, 0); // Transparent

    @Override
    public void installUI(JComponent jc) {
        super.installUI(jc);
        JTextField txt = (JTextField) comboBox.getEditor().getEditorComponent();
        txt.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent fe) {
                borderColor = new Color(255, 255, 255);
            }

            @Override
            public void focusLost(FocusEvent fe) {
                borderColor = new Color(255, 255, 255);
            }
        });

        comboBox.addPopupMenuListener(new PopupMenuListener() {
            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent pme) {
                arrowButton.setBackground(new Color(180, 180, 180));
            }

            @Override
            public void popupMenuWillBecomeInvisible(PopupMenuEvent pme) {
                arrowButton.setBackground(new Color(150, 150, 150));
            }

            @Override
            public void popupMenuCanceled(PopupMenuEvent pme) {
                arrowButton.setBackground(new Color(150, 150, 150));
            }
        });

        AutoCompleteDecorator.decorate(comboBox);
        txt.setSelectionColor(new Color(54, 189, 248));
        txt.setBorder(new EmptyBorder(0, 10, 0, 10));
        comboBox.setOpaque(false);
        comboBox.setBackground(backgroundColor);
        comboBox.setBorder(new EmptyBorder(5, 5, 5, 5));
    }

    @Override
    protected JButton createArrowButton() {
        return new ArrowButton();
    }

    @Override
    protected ComboPopup createPopup() {
        return new ComboSuggestionPopup(comboBox);
    }

    @Override
    protected ListCellRenderer createRenderer() {
        return new ListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList jlist, Object e, int i, boolean bln, boolean bln1) {
                String text = e == null ? "" : e.toString();
                JLabel label = new JLabel(text);
                label.setFont(comboBox.getFont());
                if (i >= 0) {
                    label.setBorder(new EmptyBorder(5, 8, 5, 8));
                } else {
                    label.setBorder(null);
                }
                if (bln) {
                    label.setOpaque(true);
                    label.setBackground(new Color(240, 240, 240));
                    label.setForeground(new Color(17, 155, 215));
                }
                return label;
            }
        };
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        int width = c.getWidth();
        int height = c.getHeight();
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);    //  For smooth line
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR); //  For smooth image
        g2.setColor(borderColor);
        g2.fillRoundRect(0, 0, width, height, height - 1, height - 1); // Adjust the roundness here
        g2.dispose();
        super.paint(g, c);
    }

    private class ComboSuggestionPopup extends BasicComboPopup {

        public ComboSuggestionPopup(JComboBox combo) {
            super(combo);
            setBorder(new EmptyBorder(1, 1, 1, 1));
        }

        @Override
        protected JScrollPane createScroller() {
            JScrollPane scroll = super.createScroller();
            list.setBackground(Color.WHITE);
            ScrollBarCustom sb = new ScrollBarCustom();
            sb.setPreferredSize(new Dimension(12, 70));
            scroll.setVerticalScrollBar(sb);
            ScrollBarCustom sbH = new ScrollBarCustom();
            sbH.setOrientation(JScrollBar.HORIZONTAL);
            scroll.setHorizontalScrollBar(sbH);
            scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            return scroll;
        }
    }

    private class ArrowButton extends JButton {

        public ArrowButton() {
            setContentAreaFilled(false);
            setBorder(new EmptyBorder(5, 5, 5, 5));
            setBackground(new Color(150, 150, 150));
        }

        @Override
        public void paint(Graphics grphcs) {
            super.paint(grphcs);
            Graphics2D g2 = (Graphics2D) grphcs.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            int width = getWidth();
            int height = getHeight();
            int sizeX = 12;
            int sizeY = 8;
            int x = (width - sizeX) / 2;
            int y = (height - sizeY) / 2;
            int px[] = {x, x + sizeX, x + sizeX / 2};
            int py[] = {y, y, y + sizeY};
            g2.setColor(getBackground());
            g2.fillPolygon(px, py, px.length);
            g2.dispose();
        }
    }
}
