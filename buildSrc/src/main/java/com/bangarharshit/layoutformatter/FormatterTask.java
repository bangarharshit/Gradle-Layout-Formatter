package com.bangarharshit.layoutformatter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.gradle.api.DefaultTask;
import org.gradle.api.file.ConfigurableFileTree;
import org.gradle.api.tasks.TaskAction;

public class FormatterTask extends DefaultTask {
  private ConfigurableFileTree xmlFileTree;

  public ConfigurableFileTree getXmlFileTree() { return xmlFileTree; }
  public void setXmlFileTree(ConfigurableFileTree xmlFileTree) { this.xmlFileTree = xmlFileTree; }

  @TaskAction
  void format() throws IOException {
    for (File file : xmlFileTree.getFiles()) {
      Path path = Paths.get(file.toURI());
      String content = new String(Files.readAllBytes(path));
      content = Formatter.apply(content);
      Files.write(path, content.getBytes());
    }
  }
}
