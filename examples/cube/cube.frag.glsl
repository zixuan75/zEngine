#version 330 core

in vec2 pass_texCoord;
out vec4 fragColor;

uniform sampler2D image;

void main() {
    fragColor = texture(image, pass_texCoord);
}