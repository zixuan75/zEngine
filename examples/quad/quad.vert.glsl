#version 330 core
layout(location = 0) in vec3 position;
layout(location = 1) in vec2 texCoord;

out vec2 pass_texCoord;
out vec3 color;
uniform mat3 model;
void main() {
  color = vec3(1);
  gl_Position = vec4(model * position, 1.0);
  pass_texCoord = texCoord;
}