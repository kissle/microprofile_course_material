# Use the official Nginx image as the base image
FROM nginx:alpine

# Remove the default Nginx configuration file
RUN rm /etc/nginx/conf.d/default.conf

# Copy a new configuration file from the current directory
COPY nginx.conf /etc/nginx/conf.d

# Copy the static HTML file
COPY index.html /usr/share/nginx/html

# Expose port 80
EXPOSE 80

# Start Nginx when the container has provisioned.
CMD ["nginx", "-g", "daemon off;"]
