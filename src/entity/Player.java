package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {

    GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {

        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage() {

        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_2.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {

        if(keyH.upPressed) {
            direction = "up";
            y -= speed;
        }
        else if(keyH.downPressed) {
            direction = "down";
            y += speed;
        }
        else if(keyH.leftPressed) {
            direction = "left";
            x -= speed;
        }
        else if(keyH.rightPressed) {
            direction = "right";
            x += speed;
        }

        if (keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed) {
            spriteCounter++;

            if(spriteCounter >= 10) {
                spriteNumber = spriteNumber%2+1;
                spriteCounter = 0;
            }
        }
    }

    public void draw(Graphics g2d) {

//        g2d.setColor(Color.white);
//        g2d.fillRect(x, y, gp.tilesSize, gp.tilesSize);

        BufferedImage image = null;

        switch (direction) {
            case "up":
                if(spriteNumber == 1) {
                    image = up1;
                }
                else if(spriteNumber == 2) {
                    image = up2;
                }
                break;

            case "down":
                if(spriteNumber == 1) {
                    image = down1;
                }
                else if(spriteNumber == 2) {
                    image = down2;
                }
                break;

            case "right":
                if(spriteNumber == 1) {
                    image = right1;
                }
                else if(spriteNumber == 2) {
                    image = right2;
                }
                break;

            case "left":
                if(spriteNumber == 1) {
                    image = left1;
                }
                else if(spriteNumber == 2) {
                    image = left2;
                }
                break;
        }
        g2d.drawImage(image, x, y, gp.tilesSize, gp.tilesSize, null);

    }
}
