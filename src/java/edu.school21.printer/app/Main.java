package edu.school21.printer.app;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import edu.school21.printer.logic.Logic;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

@Parameters(separators = "=")
public class Main {
  private static BufferedImage image;
  private static final String IMAGE_PATH = "target/resources/image.bmp";

  @Parameter(names = {"--white"}) private static String whiteChar;
  @Parameter(names = {"--black"}) private static String blackChar;

  public static void main(String[] args) {
    Main main = new Main();
    JCommander.newBuilder().addObject(main).build().parse(args);
    main.run();
  }

  public void run() {
    try {
      image = ImageIO.read(new File(IMAGE_PATH));
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }

    new Logic(whiteChar, blackChar).printImage(image);
  }
}