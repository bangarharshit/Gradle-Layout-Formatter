package com.bangarharshit.layoutformatter;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.file.ConfigurableFileTree;

public class XmlFormatPlugin implements Plugin<Project> {
  @Override public void apply(Project project) {
    project.getTasks().create("format", FormatterTask.class, (task) -> {
      task.setXmlFileTree(configurableFileTree(project));
    });
  }

  private ConfigurableFileTree configurableFileTree(Project project) {
    Map<String, Object> map = new HashMap<>();
    map.put("dir", project.getProjectDir());
    map.put("includes", Collections.singletonList("**/layout/*.xml"));
    ConfigurableFileTree javaFiles = project.fileTree(map);
    return javaFiles;
  }
}
