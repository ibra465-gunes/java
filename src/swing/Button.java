package swing;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class Button extends JButton {

    public Color getEffectColor() {
        return effectColor;
    }

    public void setEffectColor(Color effectColor) {
        this.effectColor = effectColor;
    }

    private Animator animator;//Animator sınıfı swingde animasyonlu geçişler için kullanılır.
    private int targetSize;
    private float animatSize;
    private Point pressedPoint;//Point sınıfı koordinat için kullanılır.
    private float alpha;
    private Color effectColor = new Color(255, 255, 255);

    public Button() {
        setContentAreaFilled(false);//Düğmeler ve menü öğeleri için ortak davranış tanımlar
        setBorder(new EmptyBorder(5, 0, 5, 0));//JComponent diğer swing bileşenlerinin kendilerini boyamaları için bir yer sağlar.
        setBackground(Color.WHITE);//setBorder bileşenin kenarlarını ayarlar. setBackground arka plan rengini ayarlar.  EmptyBorder boş şeffaf bir kenarlık sağlayan bir sınıftır. Yer kaplar ama çizmez.      
        setCursor(new Cursor(Cursor.HAND_CURSOR));//setCursor imleç görüntüsünü ayarlayan imleci ayarlar.HAND_CURSOR el imleci türü
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                targetSize = Math.max(getWidth(), getHeight()) * 2;
                animatSize = 0;
                pressedPoint = me.getPoint();
                alpha = 0.5f;
                if (animator.isRunning()) {
                    animator.stop();
                }
                animator.start();
            }
        });
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                if (fraction > 0.5f) {
                    alpha = 1 - fraction;
                }
                animatSize = fraction * targetSize;
                repaint();
            }
        };
        animator = new Animator(700, target);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        animator.setResolution(0);
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        int width = getWidth();
        int height = getHeight();
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);//BufferedImage görüntü verisi arabelleğine sahip bir görüntü tanımlar. Görüntü şlemedir.
        Graphics2D g2 = img.createGraphics();//BufferedImage.TYPE_INT_ARGB 8 bit RGBA renk bileşenlerinin paketlendiği bir görüntüyü temsil eder tamsayı pikselleri.
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);//Graphics2d sınıfından Nesnelerin olabildiğince çabuk işlenmesini mi yoksa işleme kalitesinin olabildiğince yüksek olmasını mı tercih ettiğimizi
        //ayarlayabiliriz. setRenderingHint ile görüntünün öznitelikleri ayarlanabilir.Mesela burada RenderingHints.KEY_ANTIALIASING ile kenar yumuşatma girileceği RenderingHints.VALUE_ANTIALIAS_ON ile de kenar yumuşatmanın olacağı belirtilmiş.
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, width, height, height, height);//Bu grafikleri kullanarak anahatlı yuvarlak köşeli bir dikdörtgen çizer bağlamın geçerli rengi.
        if (pressedPoint != null) {
            g2.setColor(effectColor);
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
            g2.fillOval((int) (pressedPoint.x - animatSize / 2), (int) (pressedPoint.y - animatSize / 2), (int) animatSize, (int) animatSize);
        }
        g2.dispose();//işi biten nesnelerden kurtulmaya yarar.
        grphcs.drawImage(img, 0, 0, null);
        super.paintComponent(grphcs);
    }
}
