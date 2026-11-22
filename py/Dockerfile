FROM python:3.11-slim

# Set work directory
WORKDIR /app

# Install only required build tools, then remove them after pip install
COPY requirements.txt ./
# RUN apt-get update \
#     && apt-get install -y --no-install-recommends gcc \
#     && pip install --no-cache-dir -r requirements.txt \
#     && apt-get purge -y --auto-remove gcc \
#     && rm -rf /var/lib/apt/lists/*

RUN pip install --no-cache-dir -r requirements.txt


# Copy only necessary source files (avoid .git, datasets, etc.)
COPY . .

EXPOSE 7860
CMD ["gunicorn", "--bind", "0.0.0.0:7860","--workers", "1", "--timeout", "300", "ai_detector.app:app"]
