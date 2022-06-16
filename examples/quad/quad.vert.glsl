#version 330 core
layout(location = 0) in vec3 position;
layout(location = 1) in vec2 texCoord;

out vec2 pass_texCoord;
uniform mat3 model;
void main() {
  vec3 V = model * position;
  gl_Position = vec4(V, 1.0);
  pass_texCoord = texCoord;
}