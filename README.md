# Android Project - JennSandersonBot(Discord Bot)

A Discord bot developed in Java using the JDA library for Discord integration as well as the LavaPlayer library for pulling music from Soundcloud, Youtube, locally, etc. This bot comes with an Android app that can send urls and chat messages to display and play music through the bot. This project is a group collaboration between Gavin Minney, Jacob Border, and Dalton Kellison. The bot was designed for gamers who want to effortlessly play music in a call/chat between many individuals.

## Getting Started

First, the bot has to be added to a guild or discord server. To do this, the following link can complete this task for your account.

https://discordapp.com/api/oauth2/authorize?client_id=573506204391833610&scope=bot&permissions=8 

Next, the bot will be running once invited to a server. Use command 'Jenn help' to see available commands

For playing music, here are the sources.

## Supported formats

The set of sources where LavaPlayer can load tracks from is easily extensible, but the ones currently included by default are:

* YouTube
* SoundCloud
* Bandcamp
* Vimeo
* Twitch streams
* Local files
* HTTP URLs

The file formats that LavaPlayer can currently handle are (relevant for file/url sources):

* MP3
* FLAC
* WAV
* Matroska/WebM (AAC, Opus or Vorbis codecs)
* MP4/M4A (AAC codec)
* OGG streams (Opus, Vorbis and FLAC codecs)
* AAC streams
* Stream playlists (M3U and PLS)

### Prerequisites

A device running Android 5.1 or later (min API level 21)

Discord Account

A guild for JennSandersonBot to join

### Installing

Create a Discord account at https://discordapp.com/

Join or create a server/guild

Go to https://discordapp.com/api/oauth2/authorize?client_id=573506204391833610&scope=bot&permissions=8  to add the bot to the desired guild

Type 'Jenn help' to see available commands

Commands include:

Jenn play - plays a music link by url

Jenn stop - stops all music

Jenn phone - pulls a link from the Android app to play - Must be in a voice channel

Jenn talk - pulls a chat message from the Android app to display

## Built with

LavaPlayer - Audio Player library for discord - https://github.com/sedmelluq/lavaplayer

JDA - Java Discord API - https://github.com/DV8FromTheWorld/JDA

Uses java sockets to commmunicated between host and server

## Host your own

Heavy modifications to destination and source ip addresses will have to be made within the Android app as well as CLIENT_TOKEN for a new discord bot. The core bot program can be found here - 

https://github.com/190505/CoreBot-JennSandersonBot
