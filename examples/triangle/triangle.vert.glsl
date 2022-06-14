#version 330 core
layout(location = 0) in vec2 position;
layout(location = 1) in vec3 color;
out vec4 vColor;
void main() {
  gl_Position = vec4(position, 0.0, 1.0);
  vColor = vec4(color.r, color.g, color.b, 1.0);
}