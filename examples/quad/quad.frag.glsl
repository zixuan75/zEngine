#version 330 core
out vec4 fColor;
in vec3 color;
in vec2 pass_texCoord;
uniform sampler2D image;
void main() {
  fColor = vec4(color, 1.0); //texture(image, pass_texCoord);
}