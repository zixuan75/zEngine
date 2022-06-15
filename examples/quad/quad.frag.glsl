#version 330 core
out vec4 fColor;

in vec2 pass_texCoord;
uniform sampler2D texture;
void main() {
  fColor = vec4(pass_texCoord, 0.0, 1.0);
}