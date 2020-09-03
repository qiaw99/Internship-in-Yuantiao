import imageio
import os, sys

def compose_gif():
    path = os.getcwd()
    ls = os.listdir(path)
    files = []
    fileName = __file__
    nameWithoutSuffix = fileName[:-3]
    gifName = nameWithoutSuffix + ".gif"
    
    for file in ls:
        if(file.endswith(".png")):
            files.append(file)
    print("Waiting for creating gif...")

    gif_images = []
    for path in files:
        gif_images.append(imageio.imread(path))
    if(gifName in ls):
        os.remove(gifName)
    
    imageio.mimsave(gifName,gif_images,fps=20)
    
compose_gif();
