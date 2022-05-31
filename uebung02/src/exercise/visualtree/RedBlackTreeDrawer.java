// 
// Decompiled by Procyon v0.5.36
// 

package src.exercise.visualtree;

import java.awt.event.ComponentListener;
import java.awt.Container;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentAdapter;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JFrame;

public class RedBlackTreeDrawer<T> extends JFrame
{
    private static final long serialVersionUID = 1L;
    private RedBlackTreePanel<T> panel;
    
    public RedBlackTreeDrawer() {
        (this.panel = new RedBlackTreePanel<T>()).setPreferredSize(new Dimension(800, 600));
        this.add(this.panel);
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(final ComponentEvent e) {
                final Container content = RedBlackTreeDrawer.this.getContentPane();
                RedBlackTreeDrawer.this.panel.setPreferredSize(new Dimension(content.getWidth(), content.getHeight()));
                RedBlackTreeDrawer.this.panel.repaint();
            }
        });
        this.pack();
        this.setTitle("RedBlackTreeDrawer - Dominick Leppich");
        this.setDefaultCloseOperation(3);
        this.setVisible(true);
    }
    
    public void draw(final DrawableTreeElement<T> root) {
        this.panel.draw(root);
    }
}
