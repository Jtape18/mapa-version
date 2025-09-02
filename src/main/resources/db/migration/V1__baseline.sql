-- Availability
CREATE TABLE IF NOT EXISTS availability (
  id BIGSERIAL PRIMARY KEY,
  available_rooms INT NOT NULL,
  total_rooms INT NOT NULL,
  capacity INT NOT NULL
);

-- Location
CREATE TABLE IF NOT EXISTS locations (
  id BIGSERIAL PRIMARY KEY,
  address VARCHAR(255) NOT NULL,
  latitude DOUBLE PRECISION,
  longitude DOUBLE PRECISION
);

-- Hotel
CREATE TABLE IF NOT EXISTS hotels (
  id BIGSERIAL PRIMARY KEY,
  description TEXT,
  facilities TEXT,
  is_eco BOOLEAN DEFAULT FALSE,
  name VARCHAR(255) NOT NULL,
  price_per_night NUMERIC(10,2),
  type VARCHAR(50),
  availability_id BIGINT UNIQUE,
  location_id BIGINT UNIQUE,
  CONSTRAINT fk_availability FOREIGN KEY (availability_id) REFERENCES availability(id),
  CONSTRAINT fk_location FOREIGN KEY (location_id) REFERENCES locations(id)
);

-- Hotel Photos (ElementCollection)
CREATE TABLE IF NOT EXISTS hotel_photos (
  hotel_id BIGINT NOT NULL,
  photo_url TEXT NOT NULL,
  PRIMARY KEY (hotel_id, photo_url),
  CONSTRAINT fk_hotel_photos FOREIGN KEY (hotel_id) REFERENCES hotels(id) ON DELETE CASCADE
);
