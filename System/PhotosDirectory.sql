CREATE DIRECTORY dir_artistPhotos AS 'C:\Images\ArtistPhotos';
CREATE DIRECTORY dir_productPhotos AS 'C:\Images\ProductPhotos';

GRANT READ ON DIRECTORY dir_artistPhotos TO proy1;
GRANT READ ON DIRECTORY dir_productPhotos TO proy1;