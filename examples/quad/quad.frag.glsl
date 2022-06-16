#version 330 core
out vec4 fColor;
in vec2 pass_texCoord;
uniform sampler2D image;
void main() {
  fColor = texture(image, pass_texCoord);
}