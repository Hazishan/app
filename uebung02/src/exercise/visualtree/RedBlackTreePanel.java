// 
// Decompiled by Procyon v0.5.36
// 

package src.exercise.visualtree;

import java.awt.FontMetrics;
import java.awt.Font;
import java.awt.Stroke;
import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.RenderingHints;
import java.awt.Graphics2D;
import java.awt.Graphics;
import javax.swing.JPanel;

public class RedBlackTreePanel<T> extends JPanel
{
    private static final long serialVersionUID = 1L;
    private static final int MIN_DEPTH = 4;
    private static final int NODE_SIZE = 50;
    DrawableTreeElement<T> node;
    
    public RedBlackTreePanel() {
        this.setDoubleBuffered(true);
        this.node = null;
    }
    
    public void draw(final DrawableTreeElement<T> root) {
        this.node = root;
        this.repaint();
    }
    
    @Override
    public void paint(final Graphics gOld) {
        final Graphics2D g = (Graphics2D)gOld;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        this.drawTree(g);
    }
    
    private void drawTree(final Graphics2D g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        final int depth = this.getDepth(this.node);
        final Dimension d = this.getPreferredSize();
        final int width = (int)d.getWidth();
        final int height = (int)d.getHeight();
        int size;
        for (size = 50; size > Math.pow(0.5, depth - 1) * width; --size) {}
        final int steps = (depth > 4) ? depth : 4;
        this.drawSubTree(g, this.node, 0, width, height / (steps + 1), height / (steps + 1), size);
    }
    
    private void drawSubTree(final Graphics2D g, final DrawableTreeElement<T> node, final int xMin, final int xMax, final int yLayer, final int yLayerStep, final int size) {
        final int x = xMin + (xMax - xMin) / 2;
        final int y = yLayer;
        if (node != null) {
            final int x2 = xMin + (xMax - xMin) / 4;
            final int x3 = xMin + (xMax - xMin) * 3 / 4;
            final int y2 = y + yLayerStep;
            g.setColor(Color.BLACK);
            g.setStroke(new BasicStroke(2.0f));
            g.drawLine(x, y, x2, y2);
            g.drawLine(x, y, x3, y2);
            this.drawSubTree(g, node.getLeft(), xMin, xMin + (xMax - xMin) / 2, yLayer + yLayerStep, yLayerStep, size);
            this.drawSubTree(g, node.getRight(), xMin + (xMax - xMin) / 2, xMax, yLayer + yLayerStep, yLayerStep, size);
        }
        this.drawNode(g, x, y, size, (node != null) ? node.getValue() : null, node != null && node.isRed());
    }
    
    private int getDepth(final DrawableTreeElement<T> node) {
        if (node == null) {
            return 1;
        }
        final int left = this.getDepth(node.getLeft());
        final int right = this.getDepth(node.getRight());
        return 1 + ((left > right) ? left : right);
    }
    
    private void drawNode(final Graphics2D g, final int x, final int y, final int size, final T value, final boolean red) {
        final boolean leaf = value == null;
        int fontSize = size / 3;
        if (leaf) {
            g.setColor(Color.BLACK);
            g.fillRect(x - size / 2, y - 2 * size / 6, size, 2 * size / 3);
        }
        else {
            g.setColor(red ? Color.RED : Color.BLACK);
            g.fillOval(x - size / 2, y - size / 2, size, size);
            g.setColor(Color.BLACK);
            g.drawOval(x - size / 2, y - size / 2, size, size);
        }
        final String text = (value != null) ? value.toString() : "null";
        int textWidth;
        Font font;
        int textHeight;
        do {
            font = new Font("Dialog", 1, fontSize);
            final FontMetrics metrics = g.getFontMetrics(font);
            textWidth = metrics.stringWidth(text);
            textHeight = metrics.getAscent();
            --fontSize;
        } while (textWidth > 0.8 * size);
        g.setFont(font);
        g.setColor(Color.WHITE);
        g.drawString(text, x - textWidth / 2, y + textHeight / 2);
    }
}
